package com.hippotech.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    Logger logger = LoggerFactory.getLogger(BlogController.class);

    @GetMapping("/blog")
    public String getBlog() {
        return "blog";
    }

    @PostMapping("/blog")
    public String signUpToBlog(@RequestParam(name="emailAddress", required=false, defaultValue="World") String emailAddress) {
        logger.info(emailAddress);
        return "blog";
    }
}
