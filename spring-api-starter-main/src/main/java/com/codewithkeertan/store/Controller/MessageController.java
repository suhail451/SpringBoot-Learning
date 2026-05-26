package com.codewithkeertan.store.Controller;

import com.codewithkeertan.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

//    @RequestMapping("/hello")
//    public String sayHello(){
//        return "Hello World";
//    }

    @RequestMapping("/hello")
    public Message sayHello(){
        return new Message("Hello World") ;
    }

}
