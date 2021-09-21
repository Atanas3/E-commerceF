package com.example.empdep1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String indexPage() {
        return "redirect:/students";
    }

    @GetMapping("/home")
    public String getHomePage(HttpServletRequest req, HttpServletResponse res) {
        return "/students";
    }
}

