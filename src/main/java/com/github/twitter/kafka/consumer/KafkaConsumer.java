package com.github.twitter.kafka.consumer;

import com.github.twitter.kafka.config.KafkaConfig;
import com.github.twitter.kafka.config.MongoDBConfig;
import com.github.twitter.kafka.constants.Kafka;
import com.mongodb.client.MongoCollection;
import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
/**
 * Consumer class which reads data from kafka topic and insert the document into mongoDB.
 */

public class KafkaConsumer {

    public static void main(String[] args) throws IOException {

        new KafkaConsumer().run();
    }

    private static void run() {

        Logger logger = LoggerFactory.getLogger(KafkaConsumer.class.getName());

        KafkaConfig config = new KafkaConfig();
        MongoDBConfig mongoConfig = new MongoDBConfig();

        MongoCollection<Document> collection = mongoConfig.createDBConnection();

        org.apache.kafka.clients.consumer.KafkaConsumer<String, String> consumer = config.createConsumer(Kafka.TOPIC);

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                Document doc = Document.parse(record.value());
                collection.insertOne(doc);
            }
            try {
                consumer.commitSync();
            } catch (CommitFailedException e) {
                logger.info("commit failed :{}", e);
            }
        }
    }
}
