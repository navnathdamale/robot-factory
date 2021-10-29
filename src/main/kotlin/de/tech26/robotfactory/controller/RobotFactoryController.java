package de.tech26.robotfactory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Robot Factory Greeting controller
 */
@RestController
public class RobotFactoryController {
    @GetMapping("/")
    public String hello() {
        return "Greetings from Robot Factory!";
    }
}