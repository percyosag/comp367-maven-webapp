package com.percybuilder.mavenwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {

        int hour = LocalTime.now().getHour();

        if (hour < 12) {
            return "Good morning, Percy, Welcome to COMP367";
        } else {
            return "Good afternoon, Percy, Welcome to COMP367";
        }
    }
}