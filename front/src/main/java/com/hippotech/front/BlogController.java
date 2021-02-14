package com.hippotech.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BlogController {
    private Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Value("${blog.url}")
    private String blogBackendUrl;

    @GetMapping("/blog")
    public String getBlog() {
        return "blog";
    }

    @PostMapping("/blog")
    public String signUpToBlog(@RequestParam(name="emailAddress", required=false, defaultValue="World") String emailAddress) {
        logger.info(emailAddress);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("email", emailAddress);

        String url = this.blogBackendUrl + "/signup";

        //String body = "{ \"email\" : \"" + emailAddress + "\" }";
        //RestTemplate restTemplate = new RestTemplate();
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//        HttpEntity<String> request = new HttpEntity<String>(body, headers);
//        restTemplate.postForObject(url, request, String.class);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);

        return "blog";
    }
}
