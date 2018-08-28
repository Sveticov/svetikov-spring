package com.svetikov.svetikovspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Slf4j
@Controller
public class WelcomeLoginController {
private String name="fox99";
    @GetMapping("/welcome")
    public void welcomeGet() {

    }

    @PostMapping("/welcome")
    public void welcomePost() {

    }

    @GetMapping("/image1")
    public String img1(Model model){
        model.addAttribute("username",name);
        return "image_1";
    }
    @GetMapping("/image2")
    public String img2(Model model){
        model.addAttribute("username",name);
        return "image_2";
    }
    @GetMapping("/image3")
    public String img3(Model model){
        model.addAttribute("username",name);
        return "image_3";
    }
    @GetMapping("/image4")
    public String img4(Model model){
        model.addAttribute("username",name);
        return "image_4";
    }
    @GetMapping("/image5")
    public String img5(Model model){
        model.addAttribute("username",name);
        return "image_5";
    }

    @GetMapping("/my_count")
    public String getEventCount()
    {

        return "test";
    }
}
