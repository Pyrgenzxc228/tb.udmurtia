package ru.udmurtia.tb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Этот метод показывает страницу входа
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Spring найдет файл login.html в папке templates
    }

    // Этот метод показывает главную страницу после успешного входа
    @GetMapping("/")
    public String homePage() {
        return "home"; // Нам нужно будет создать файл home.html
    }
}