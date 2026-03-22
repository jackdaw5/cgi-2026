package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller  
public class DemoexampleApplication {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("reservedTable", null);
        model.addAttribute("customerName", null);
        return "restoran-layout"; 
    }

    @PostMapping("/reserve")
    public String reserveTable(@RequestParam String tableId, @RequestParam String customerName, Model model) {
        model.addAttribute("reservedTable", tableId);
        model.addAttribute("customerName", customerName);
        return "restoran-layout"; 
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoexampleApplication.class, args);
    }
}