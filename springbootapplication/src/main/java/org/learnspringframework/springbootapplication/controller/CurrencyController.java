package org.learnspringframework.springbootapplication.controller;

import org.learnspringframework.springbootapplication.Configurations.CurrencyConfigurationService;
import org.learnspringframework.springbootapplication.Data.Persons;
import org.learnspringframework.springbootapplication.service.PersonService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {

    private final CurrencyConfigurationService configurationService;


    public CurrencyController(CurrencyConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @RequestMapping("/currency-configuration")
    public CurrencyConfigurationService getUsers(){
        return configurationService;
    }
}
