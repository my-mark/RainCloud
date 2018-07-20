package com.raincloud.servicefeign.service;

import com.raincloud.servicefeign.clients.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService implements HelloService {

    @Autowired
    private HelloService serviceHi;

    @Override
    public String sayHiFromClientOne(String name) {
        return serviceHi.sayHiFromClientOne(name);
    }
}
