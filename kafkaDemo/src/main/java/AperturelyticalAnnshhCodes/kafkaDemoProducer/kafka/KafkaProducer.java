package AperturelyticalAnnshhCodes.kafkaDemoProducer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    // the k-v need not just be string, it can be custom types also. But you need to serialize and deserialize
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // Constructor Injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent : %s", message));

        // finance is coming from config - KafkaTopicConfig
        kafkaTemplate.send("finance", message);
    }
}
