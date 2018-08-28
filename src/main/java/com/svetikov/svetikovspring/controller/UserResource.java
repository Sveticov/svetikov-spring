package com.svetikov.svetikovspring.controller;

import com.svetikov.svetikovspring.model.MyVal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class UserResource {

    @GetMapping("/user")
    public String helloUser() {
        return "Welcome to SpringBoot";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String securedUser() {
        return "Welcome sdmin to this tutorial";
    }

    @GetMapping("/myval")
    public MyVal myVal() {
        MyVal myVal = new MyVal();
        Random rnd = new Random();
        int val = rnd.nextInt(700);
        int val2 = rnd.nextInt(1100);
        String valStr = String.valueOf(val);
        String valStr2 = String.valueOf(val2);
        myVal.setMydata(valStr);
        myVal.setMydata2(valStr2);
        myVal.setStatus("ok");
        return myVal;
    }
}
