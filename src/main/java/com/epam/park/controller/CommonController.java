package com.epam.park.controller;

import com.epam.park.model.Forester;
import com.epam.park.service.api.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommonController {

    @Autowired
    CommonService commonService;

    @RequestMapping(value = "/")
    public String showTitlePage() {
        return "title";
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public @ResponseBody boolean checkEmail(@RequestParam(name = "email") String email) {
        return commonService.isEmailFree(email);
    }

    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public @ResponseBody String checkUser(@RequestParam(name = "email") String email,
                                          @RequestParam(name = "password") String password) {
        if (commonService.isEmailFree(email)) return "no such user";
        if (commonService.isPasswordCorrect(email, password)) return "submit";
        else return "incorrect password";
    }

    @RequestMapping(value = "/redirectHome", method = RequestMethod.POST)
    public String redirectToHome() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/registration")
    public String addUserToDatabase(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "name") String name,
                                    @RequestParam(name = "surname") String surname,
                                    @RequestParam(name = "password") String password) {
        commonService.saveForester(new Forester(email, password, name, surname));
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }
}
