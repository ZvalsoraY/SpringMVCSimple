package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/index")
    public String index() {
        System.out.println("hello!");
        return "index";
    }
}
