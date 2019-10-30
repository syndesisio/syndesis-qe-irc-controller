package io.syndesis.qe.entity;

public class IrcMessageRequest {
    private String username;
    private String message;

    public IrcMessageRequest() {
    }

    public IrcMessageRequest(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}
