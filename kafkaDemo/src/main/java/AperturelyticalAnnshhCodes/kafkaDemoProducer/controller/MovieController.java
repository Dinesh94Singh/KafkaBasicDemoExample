package AperturelyticalAnnshhCodes.kafkaDemoProducer.controller;

import AperturelyticalAnnshhCodes.kafkaDemoProducer.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/imdbservice/")
public class MovieController {
    private KafkaProducer kafkaProducer;


    // constructor injection
    public MovieController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/v1/imdbservice/buyMovie?id={movie_id}
    @GetMapping("/buyMovie")
    public ResponseEntity<String> buyMovie(@RequestParam("id") String movieId) {
        kafkaProducer.sendMessage(movieId);
        return ResponseEntity.ok("Sent to Payment Service Topic");
    }
}
