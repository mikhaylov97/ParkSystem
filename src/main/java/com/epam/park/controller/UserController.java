package com.epam.park.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "")
    public String showMainPage() {
        return "main";
    }
}
