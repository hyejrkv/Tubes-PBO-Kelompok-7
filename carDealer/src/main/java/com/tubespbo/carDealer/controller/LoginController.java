package com.tubespbo.carDealer.controller;

import com.tubespbo.carDealer.models.User;
import com.tubespbo.carDealer.services.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login/index";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model,
            HttpSession session) {
        User user = userService.login(username, password);
        // System.out.println("USER:" + user);
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login/index";
        }
    }

    @GetMapping("/logout")
    public String handleLogout(Model model, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
