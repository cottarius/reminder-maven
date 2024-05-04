package ru.cotarius.reminder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.cotarius.reminder.service.UserService;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

//    @GetMapping("any")
//    public String any(){
//        return "any";
//    }
//    @GetMapping("admin")
//    public String admin(){
//        return "admin";
//    }
//
//    @GetMapping("user")
//    public String user(){
//        return "user";
//    }
//
//    @GetMapping("auth")
//    public String auth(){
//        return "auth";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/")
    public String home() {
        return "index_temp";
    }

}
