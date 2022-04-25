package com.github.twitter.kafka.config;

import com.github.twitter.kafka.constants.Kafka;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Kafka configuration class
 */

public class KafkaConfig {

    public static KafkaConsumer<String, String> createConsumer(String topic) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Kafka.BOOTSTRAPSERVERS);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, Kafka.GROUP_ID);
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Kafka.AUTO_COMMIT_FLAG);
        properties.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, Kafka.AUTO_COMMIT_CONFIG);
        properties.setProperty(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, Kafka.TIMEOUT);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Kafka.OFFSET_CONFIG);

        KafkaConsumer<String, String>
                consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topic));

        return consumer;
    }
}
