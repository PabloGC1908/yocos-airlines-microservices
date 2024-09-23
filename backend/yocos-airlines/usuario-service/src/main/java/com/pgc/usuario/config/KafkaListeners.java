package com.pgc.usuario.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListeners {

    @KafkaListener(topics = "yoquito", groupId = "yoco")
    void listener(String data) {
        log.info("Received: {}", data);
    }
}
