package com.hippotech.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @GetMapping("/signin")
    public String greeting() {
        //
        return "signin";
    }
}
