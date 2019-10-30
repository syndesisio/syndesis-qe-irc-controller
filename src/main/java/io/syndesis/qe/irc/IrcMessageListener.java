package io.syndesis.qe.irc;

import org.schwering.irc.lib.IRCEventListener;
import org.schwering.irc.lib.IRCModeParser;
import org.schwering.irc.lib.IRCUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IrcMessageListener implements IRCEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger("IrcMessageListener");

    private Map<String, List<String>> receivedMessages = new HashMap<>();

    public Map<String, List<String>> getReceivedMessages() {
        return receivedMessages;
    }

    @Override
    public void onRegistered() {
    }

    @Override
    public void onDisconnected() {
    }

    @Override
    public void onError(String s) {
    }

    @Override
    public void onError(int i, String s) {
    }

    @Override
    public void onInvite(String s, IRCUser ircUser, String s1) {
    }

    @Override
    public void onJoin(String s, IRCUser ircUser) {
    }

    @Override
    public void onKick(String s, IRCUser ircUser, String s1, String s2) {
    }

    @Override
    public void onMode(String s, IRCUser ircUser, IRCModeParser ircModeParser) {
    }

    @Override
    public void onMode(IRCUser ircUser, String s, String s1) {
    }

    @Override
    public void onNick(IRCUser ircUser, String s) {
    }

    @Override
    public void onNotice(String s, IRCUser ircUser, String s1) {
    }

    @Override
    public void onPart(String s, IRCUser ircUser, String s1) {
    }

    @Override
    public void onPing(String s) {
    }

    @Override
    public void onPrivmsg(String chan, IRCUser ircUser, String msg) {
        LOGGER.info("Received message: Channel: " + chan + ", user: " + ircUser.getNick() + ", message: " + msg);
        receivedMessages.computeIfAbsent(chan, v -> new ArrayList<>()).add(msg);
    }

    @Override
    public void onQuit(IRCUser ircUser, String s) {
    }

    @Override
    public void onReply(int i, String s, String s1) {
    }

    @Override
    public void onTopic(String s, IRCUser ircUser, String s1) {
    }

    @Override
    public void unknown(String s, String s1, String s2, String s3) {
    }
}
