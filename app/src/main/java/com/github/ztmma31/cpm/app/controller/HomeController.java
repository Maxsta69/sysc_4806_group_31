package com.github.ztmma31.cpm.app.controller;

import com.github.ztmma31.cpm.app.model.AppUser;
import com.github.ztmma31.cpm.app.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserRepository users;

    public HomeController(UserRepository users) { this.users = users; }

    @GetMapping("/")
    public String root() { return "redirect:/home"; }

    @GetMapping("/home")
    public String home(Authentication auth, Model model) {
        AppUser user = users.findByEmail(auth.getName()).orElseThrow();
        model.addAttribute("name", user.getName());
        model.addAttribute("role", user.getRole());
        return "home";
    }
}
