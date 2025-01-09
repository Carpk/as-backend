package com.thekleinbottle.as_backend.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelpTicketController {


    @GetMapping("/help-ticket")
    public String getMethodName() {
        return new String("Help is coming!");
    }
    

}
