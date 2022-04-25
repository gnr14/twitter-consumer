package com.github.twitter.kafka.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class KafkaConfigTest {

    @Test
    public void validateKafkaConfig() {
        KafkaConfig config = new KafkaConfig();
        KafkaConsumer<String, String> kafkaConsumer = config.createConsumer("test");

        assertNotNull(kafkaConsumer.toString());

    }

}
