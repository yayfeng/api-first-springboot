package it.pagopa.pn.experiment.api_first_springboot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    @RequestMapping("/{path}/")
    public static class RootController {

        @Value("${required.root.path}")
        private String configuredRootPath;

        @GetMapping("info")
        public Map<String, ?> info(
                @PathVariable("path") String path,
                @RequestHeader Map<String, String> headers
        ) {
            Map<String, Object> info = new HashMap<>();
            info.put( "env", System.getenv() );
            info.put( "headers", headers );
            info.put( "now", Instant.now().toString() );
            info.put( "configured-root-path", this.configuredRootPath);
            info.put( "request-path", path);
            info.put( "name", "app_2022_02_01_12_05");
            return info;
        }
    }

}
