package com.hippotech.front;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SvgController {
    @GetMapping(value = "/svg", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML(@RequestParam(required=false, defaultValue="") String color) {
        String page = "<iframe srcdoc=\"&lt;img src&equals;x:x onerror&equals;alert&lpar;1&rpar;&gt;\" other=\"" + color + "\"/>";
        return page;
    }
}
