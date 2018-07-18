package com.raincloud.serviceribbon.controller;

import com.raincloud.serviceribbon.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/hi")
    public String helloWorld(@RequestParam String name) {
        return demoService.helloWorld(name);
    }

}
