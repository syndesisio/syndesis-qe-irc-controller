package io.syndesis.qe.entity;

public class IrcConnectRequest {
    private String channels;

    public IrcConnectRequest() {
    }

    public IrcConnectRequest(String channels) {
        this.channels = channels;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }
}
