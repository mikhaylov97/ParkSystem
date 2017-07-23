package com.epam.park.controller;

import com.epam.park.model.User;
import com.epam.park.model.roles.UserRoleEnum;
import com.epam.park.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @RequestMapping(value = "")
    public String showMainPage() {
        return "main";
    }

    @RequestMapping(value = "/addAdmin")
    public String showAddAdminPage() {
        return "addAdmin";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String addAdmin(@RequestParam(name = "email") String email,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "surname") String surname,
                           @RequestParam(name = "password") String password) {
        User user = new User(UserRoleEnum.ROLE_ADMIN.name(), email, password, name, surname);
        adminService.addAdmin(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/delete")
    public ModelAndView showDeletePage() {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("admins", adminService.getAllAdmins());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteAdmin(@PathVariable(name = "id") String id) {
        adminService.removeAdmin(Long.parseLong(id));
        return "redirect:/login";
    }

    @RequestMapping(value = "/accepting")
    public ModelAndView showAcceptingPage() {
        ModelAndView modelAndView = new ModelAndView("accepting");
        modelAndView.addObject("tasks", adminService.getDoneTasks());

        return modelAndView;
    }

    @RequestMapping(value = "/accepting/accept/{id}", method = RequestMethod.POST)
    public String acceptTask(@PathVariable(name = "id") String id) {
        adminService.acceptTask(Long.parseLong(id));
        return "redirect:/admin/accepting";
    }

    @RequestMapping(value = "/accepting/decline/{id}", method = RequestMethod.POST)
    public String declineTask(@PathVariable(name = "id") String id) {
        adminService.acceptTask(Long.parseLong(id));
        return "redirect:/admin/accepting";
    }
}
