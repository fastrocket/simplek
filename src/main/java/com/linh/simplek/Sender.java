package com.linh.simplek;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class Sender {

    private static final Logger LOGGER = getLogger(Sender.class);

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public void send(String topic, String payload) {
    public void send(String payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
//        kafkaTemplate.send(topic, payload);
        kafkaTemplate.send(topic, payload);
    }
}