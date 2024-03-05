package org.futurecollars.lesson12.task2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        String upperCaseName = name.toUpperCase();
        return "Hello   " + upperCaseName;
    }
}
