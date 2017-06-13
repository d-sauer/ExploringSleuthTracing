package com.example.sltrac.demoA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * @author Davor Sauer
 */
@RestController
public class Index {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public LocalDateTime index() {
        logger.info("index page A");

        return LocalDateTime.now();
    }

    @GetMapping("/service")
    public Object service(@RequestParam("uri") String uri) {
        logger.info("get URI '{}'", uri);

        Object forObject = restTemplate.getForObject(uri, Object.class);


        return forObject;
    }

    @GetMapping("/retry")
    public Object service2(@RequestParam(value = "retry", required = false) Integer retry, @RequestParam("uri") String uri) {
        if (retry <= 0) {
            retry = 1;
        }

        for(int n = 1; n < retry; n++) {
            logger.info("GET URI {} : '{}'",n, uri);
            restTemplate.getForObject(uri, Object.class);
        }

        return retry;
    }

}
