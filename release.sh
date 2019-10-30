#!/usr/bin/env bash

if [ "$#" -eq 0 ]; then
	echo "No tag specified, using default syndesisqe/irc-controller"
	TAG="syndesisqe/irc-controller"
else
	TAG="$1"
fi

echo "Building project"
mvn package -Pnative -Dnative-image.docker-build=true

echo "Building docker image"

docker build -f src/main/docker/Dockerfile -t "${TAG}" .

docker push "${TAG}"
