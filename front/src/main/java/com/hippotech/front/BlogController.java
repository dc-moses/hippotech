package com.hippotech.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);

        return "blog";
    }

    @GetMapping("/blog-signup")
    public String signUp(@RequestParam(name="emailAddress", required=false, defaultValue="World") String emailAddress) {
        logger.error("Signup GET");

        try {
            URL url = new URL(this.blogBackendUrl + "/signup?email=" + emailAddress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream response = con.getInputStream();
        } catch (Exception e) {

        }
        return "blog";
    }
}
