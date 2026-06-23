package org.learnspringframework.springbootapplication.controller;

import org.learnspringframework.springbootapplication.service.MarksService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarksController {

    private final MarksService marksService;

    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    @RequestMapping("/marks")
    public Integer getTotalMarks(){
        return marksService.getTotalMarks();
    }

}
