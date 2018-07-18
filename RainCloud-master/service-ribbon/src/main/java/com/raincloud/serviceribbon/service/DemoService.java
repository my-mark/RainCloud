package com.raincloud.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {

    @Autowired
    private RestTemplate restTemplate;

    public String helloWorld(String name) {
        return restTemplate.getForObject("http://service-hello/hi?name=" + name, String.class);
    }
}
