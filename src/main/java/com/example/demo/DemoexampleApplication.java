package com.example.demo;

import java.util.ArrayList;
import java.util.List;

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
    
    // Storage for reservations
    //In futher develompent would have been moved to a seperate file with reservation logic
    private List<Reservation> reservations = new ArrayList<>();

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("reservations", reservations);
        model.addAttribute("reservedTable", null);
        model.addAttribute("customerName", null);
        model.addAttribute("date", null);
        model.addAttribute("time", null);
        model.addAttribute("errorMessage", null);
        model.addAttribute("successMessage", null);
        return "restoran-layout"; 
    }

    @PostMapping("/reserve")
    public String reserveTable(@RequestParam String tableId, 
                               @RequestParam String customerName, 
                               @RequestParam String date,
                               @RequestParam String time,
                               Model model) {
        
        
        boolean tableTaken = false;
        String existingCustomer = "";
        
        for (Reservation r : reservations) {
            String existingTime = r.getTime();
            String existingDate = r.getDate();
            String existingTableId = r.getTableId();
            
            if (existingTableId != null && existingTableId.equals(tableId) &&
                existingDate != null && existingDate.equals(date) &&
                existingTime != null && existingTime.equals(time)) {
                tableTaken = true;
                existingCustomer = r.getCustomerName();
                break;
            }
        }
        
        if (tableTaken) {
            model.addAttribute("errorMessage", "Table " + tableId + " is already reserved by " + existingCustomer + " at " + time + " on " + date);
            model.addAttribute("successMessage", null);
        } else {
            Reservation newReservation = new Reservation(tableId, customerName, date, time);
            reservations.add(newReservation);
            model.addAttribute("successMessage", customerName + " reserved table " + tableId + " for " + date + " at " + time);
            model.addAttribute("errorMessage", null);
        }
        
        model.addAttribute("reservations", reservations);
        model.addAttribute("reservedTable", tableId);
        model.addAttribute("customerName", customerName);
        model.addAttribute("date", date);
        model.addAttribute("time", time);
        
        return "restoran-layout";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoexampleApplication.class, args);
    }
    
    // INNER CLASS — Reservation
    public static class Reservation {
        private String tableId;
        private String customerName;
        private String date;
        private String time;
        
        public Reservation(String tableId, String customerName, String date, String time) {
            this.tableId = tableId;
            this.customerName = customerName;
            this.date = date;
            this.time = time;
        }
        
        public String getTableId() {
            return tableId;
        }
        
        public String getCustomerName() {
            return customerName;
        }
        
        public String getDate() {
            return date;
        }
        
        public String getTime() {
            return time;
        }
    }
}