package com.linh.simplek;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class Receiver {

    private static final Logger LOGGER = getLogger(Receiver.class);

//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }

    @KafkaListener(topics = "${kafka.topic}")
//    public void receive(ConsumerRecord<?, ?> consumerRecord) {
    public void receive(String message) {
//        LOGGER.info("received payload='{}'", consumerRecord.toString());
        LOGGER.info("received payload='{}'", message);
//        latch.countDown();
    }
}