package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "") String password) {
            this.logger.error(password);
            return "completed";
    }
}
