package AperturelyticalAnnshhCodes.kafkaDemoConsumer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "finance", groupId = "financeConsumerGroup")
    public void consume(String movieId) {
        LOGGER.info(String.format("Movie ID received is  -> %s", movieId));
    }

}
