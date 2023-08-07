package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class TimeController {

    private final Logger logger = LoggerFactory.getLogger(TimeController.class);

    @GetMapping("/time")
    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        logger.info("`Current date and time`: {}", now.toString());
        return now.toString();
    }
}

