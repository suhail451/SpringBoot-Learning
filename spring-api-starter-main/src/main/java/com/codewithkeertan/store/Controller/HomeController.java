package com.codewithkeertan.store.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")  // for home page
    public String index(Model model){
        model.addAttribute("name", "Keertan");
//        return "index.html"; // this is in resources/static/html/index.html
        return "index";
    }

//    @RequestMapping("/hello")  // for home page
//    public String sayHello(){
//        return "index.html"; // this is in resources/static/html/index.html
//    }

}
