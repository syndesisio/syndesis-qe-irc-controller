package io.syndesis.qe.rest;

import io.syndesis.qe.entity.IrcMessageRequest;
import io.syndesis.qe.irc.Irc;
import io.syndesis.qe.entity.IrcConnectRequest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Map;

@Path("/irc")
public class IrcResource {
    @Inject
    Irc irc;

    @POST
    @Path("/connect")
    @Consumes(MediaType.APPLICATION_JSON)
    public void connect(IrcConnectRequest connectRequest) {
        irc.connect(connectRequest.getChannels().split(","));
    }

    @POST
    @Path("/messages")
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendMessage(IrcMessageRequest messageRequest) {
        irc.sendMessage(messageRequest.getUsername(), messageRequest.getMessage());
    }

    @GET
    @Path("/messages")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<String>> messages() {
        return irc.getListener().getReceivedMessages();
    }
}
