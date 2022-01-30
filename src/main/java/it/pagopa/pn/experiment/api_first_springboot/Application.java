package it.pagopa.pn.experiment.api_first_springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    @RequestMapping("/delivery/")
    public static class RootController {

        @GetMapping("info")
        public Map<String, ?> info() {
            Map<String, Object> info = new HashMap<>();
            info.put( "env", System.getenv() );
            info.put( "now", Instant.now().toString() );
            info.put( "name", "app2");
            return info;
        }
    }

}
