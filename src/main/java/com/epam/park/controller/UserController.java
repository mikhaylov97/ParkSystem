package com.epam.park.controller;

import com.epam.park.model.User;
import com.epam.park.service.api.CommonService;
import com.epam.park.service.api.ForesterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    CommonService commonService;

    @Autowired
    ForesterService foresterService;

    @RequestMapping(value = "")
    public ModelAndView showMainPage() {
        ModelAndView modelAndView = new ModelAndView("main");
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("newTasks",foresterService.getNewTasks(userEmail).size());
        modelAndView.addObject("newDeclines", foresterService.getDeclinedTasks(userEmail).size());
        return modelAndView;
    }

    @RequestMapping(value = "/edit")
    public String showEditPage() {
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String changeSettings(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "surname") String surname,
                                 @RequestParam(name = "password") String password) {
        User user = commonService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        commonService.saveUser(user);
        log.info("Пользователь под именем " + user.getEmail() + " изменил свои некоторые данные.");
        return "redirect:/login";
    }

    @RequestMapping(value = "/tasks")
    public ModelAndView showNewTasksPage() {
        ModelAndView modelAndView = new ModelAndView("newTasks");
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("tasks", foresterService.getNewTasks(userEmail));
        return modelAndView;
    }

    @RequestMapping(value = "/tasks/done/{id}", method = RequestMethod.POST)
    public String makeTaskDone(@PathVariable(name = "id") String id) {
        foresterService.makeTaskDone(Long.parseLong(id));
        log.info("Пользователь под именем + " + SecurityContextHolder.getContext().getAuthentication().getName()
                 + " выполнил задание №" + id + ".");
        return "redirect:/user";
    }

    @RequestMapping(value = "/tasks/declined")
    public ModelAndView showDeclinesPage() {
        ModelAndView modelAndView = new ModelAndView("declines");
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("declines", foresterService.getDeclinedTasks(userEmail));

        return modelAndView;
    }
}
