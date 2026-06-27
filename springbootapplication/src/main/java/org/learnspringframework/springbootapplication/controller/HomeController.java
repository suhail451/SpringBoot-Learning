package org.learnspringframework.springbootapplication.controller;

import org.learnspringframework.springbootapplication.Configurations.HomeConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final HomeConfiguration homeConfiguration;

    public HomeController(HomeConfiguration homeConfiguration) {
        this.homeConfiguration = homeConfiguration;
    }

    @RequestMapping("/home")
    public HomeConfiguration getHomeConfig(){
        return homeConfiguration;
    }
}
