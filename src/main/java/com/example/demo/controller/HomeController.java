package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController
{

    @GetMapping("/")
        public String HomeMetode(){

            return "home";
    }

    @PostMapping("/")
    public String CreateMetode(){

        return "Create";
    }

    @PostMapping("/")
    public String UpdateMetode(){

        return "Update";
    }


}
