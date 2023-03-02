package com.iconsult.controller;

import com.iconsult.kafka.JsonKafkaProducer;
import com.iconsult.payload.User;
import com.iconsult.repositorry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
@Autowired
private JsonKafkaProducer kafkaProducer;
@Autowired
    UserRepo userRepo;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @GetMapping("/showdb")
    public ResponseEntity<List<User>> shpwdb(){
        return ResponseEntity.ok(this.userRepo.findAll());
    }
}
