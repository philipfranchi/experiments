package com.philipfranchi.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RestController
@RequestMapping("/dummy")
public class DummyController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DummyController.class);

    @PostMapping
    public ResponseEntity<?> postDummy() {
        return ResponseEntity.ok(Instant.now());
    }
}
