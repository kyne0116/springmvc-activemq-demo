package com.simbest.jms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lishuyi
 */
@RestController
public class MessageSenderController {

    @Autowired
    @Qualifier("jmsTemplateTopic")
    private JmsTemplate jmsTemplateTopic;

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSenderController.class);

    @RequestMapping(value = "/sendSampleTopic", method = RequestMethod.GET)
    public String sendSampleTopic() {
        try {
            jmsTemplateTopic.send(session -> session.createTextMessage("Send Sample Topic Message!"));
            return "SAMPLE MESSAGE WAS SENT";
        } catch (JmsException e) {
            LOGGER.debug("Error: ", e);
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/sendTopic", method = RequestMethod.POST)
    public String sendTopic(@RequestBody String msg) {
        try {
            jmsTemplateTopic.send(session -> session.createTextMessage(msg));
            return "TOPIC MESSAGE WAS SENT";
        } catch (JmsException e) {
            LOGGER.debug("Error: ", e);
            return e.getMessage();
        }
    }


}
