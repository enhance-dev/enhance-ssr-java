package dev.enhance.springdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.enhance.springdemo.EnhanceSsrWasm;

@SpringBootApplication
@RestController
public class SpringDemoApplication {
    public static void main(String[] args) {
      SpringApplication.run(SpringDemoApplication.class, args);
    }
    @GetMapping("/")
    public String ssr(@RequestParam(value = "name", defaultValue = "World") String name) {
      return EnhanceSsrWasm.ssr("<my-header>Hello world!</my-header>");
    }
}
