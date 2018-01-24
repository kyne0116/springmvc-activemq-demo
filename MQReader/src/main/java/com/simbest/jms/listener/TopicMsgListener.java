package com.simbest.jms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lishuyi
 */
public class TopicMsgListener {

    private static final Logger log = LoggerFactory.getLogger(TopicMsgListener.class);

    /**
     * Method that read the Topic when exists messages.
     * This method is a listener
     *
     * @param msg - String message
     */
    public void onMessage(String msg) {
        log.debug("-----------------------------------------------------------");
        log.debug("Receive topic message: " + msg);
    }

}
