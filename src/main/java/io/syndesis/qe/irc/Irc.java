package io.syndesis.qe.irc;

import org.schwering.irc.lib.IRCConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

import java.io.IOException;

@ApplicationScoped
public class Irc {
    private static final Logger LOGGER = LoggerFactory.getLogger("Irc");

    private IRCConnection ircConnection;
    private IrcMessageListener listener;

    @PreDestroy
    public void disconnect() {
        LOGGER.info("Disconnecting");
        ircConnection.close();
    }

    public void connect(String... channels) {
        LOGGER.info("Connecting to " + System.getProperty("host") + ":6667");
        if (ircConnection != null) {
            ircConnection.close();
        }

        ircConnection = new IRCConnection(
            System.getProperty("host"),
            new int[] { 6667 },
            "",
            "quarkus-irc-controller",
            "quarkus-irc-controller",
            "quarkus-irc-controller");
        listener = new IrcMessageListener();
        ircConnection.addIRCEventListener(listener);
        try {
            ircConnection.connect();
        } catch (IOException e) {
            LOGGER.error("Unable to connect to IRC server", e);
        }

        // Wait a bit for the connection to fully initialize
        try {
            Thread.sleep(15000L);
        } catch (InterruptedException ignored) {
        }

        for (String channel : channels) {
            LOGGER.info("Joining channel: " + channel);
            ircConnection.doJoin(channel);
        }
    }

    public IrcMessageListener getListener() {
        return listener;
    }

    public void sendMessage(String user, String message) {
        ircConnection.doPrivmsg(user, message);
    }
}
