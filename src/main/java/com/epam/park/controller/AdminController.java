package com.epam.park.controller;

import com.epam.park.model.Order;
import com.epam.park.model.User;
import com.epam.park.model.roles.UserRoleEnum;
import com.epam.park.service.impl.AdminServiceImpl;
import com.epam.park.service.impl.CommonServiceImpl;
import com.epam.park.service.impl.PlantServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static final Logger log = Logger.getLogger(AdminController.class);

    @Autowired
    AdminServiceImpl adminService;

    @Autowired
    CommonServiceImpl commonService;

    @Autowired
    PlantServiceImpl plantService;

    @RequestMapping(value = "")
    public String showMainPage(Locale locale) {
        return "main";
    }

    @RequestMapping(value = "/addAdmin")
    public String showAddAdminPage(Locale locale) {
        return "addAdmin";
    }

    @RequestMapping(value = "/edit")
    public String showEditPage(Locale locale) {
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String changeSettings(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "surname") String surname,
                                 @RequestParam(name = "password") String password,
                                 Locale locale) {
        User user = commonService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        commonService.saveUser(user);
        log.info("Админ под именем " + user.getEmail() + " изменил свои некоторые данные.");
        return "redirect:/login";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String addAdmin(@RequestParam(name = "email") String email,
                           @RequestParam(name = "name") String name,
                           @RequestParam(name = "surname") String surname,
                           @RequestParam(name = "password") String password,
                           Locale locale) {
        User user = new User(UserRoleEnum.ROLE_ADMIN.name(), email, password, name, surname);
        adminService.addAdmin(user);
        log.info("Добавлен новый админ под именем " + email + ".");
        return "redirect:/login";
    }

    @RequestMapping(value = "/delete")
    public ModelAndView showDeletePage(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("admins", adminService.getAllAdmins());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteAdmin(@PathVariable(name = "id") String id, Locale locale) {
        adminService.removeAdmin(Long.parseLong(id));
        log.info("Удален один из админов.");
        return "redirect:/login";
    }

    @RequestMapping(value = "/accepting")
    public ModelAndView showAcceptingPage(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("accepting");
        modelAndView.addObject("tasks",
                adminService.getDoneTasks(SecurityContextHolder.getContext().getAuthentication().getName()));

        return modelAndView;
    }

    @RequestMapping(value = "/accepting/accept/{id}", method = RequestMethod.POST)
    public String acceptTask(@PathVariable(name = "id") String id, Locale locale) {
        adminService.acceptTask(Long.parseLong(id));
        log.info("Админом " + SecurityContextHolder.getContext().getAuthentication().getName()
                 + " принято задание №" + id + ".");
        return "redirect:/admin/accepting";
    }

    @RequestMapping(value = "/accepting/decline/{id}", method = RequestMethod.POST)
    public String declineTask(@PathVariable(name = "id") String id, Locale locale) {
        adminService.declineTask(Long.parseLong(id));
        log.info("Админом " + SecurityContextHolder.getContext().getAuthentication().getName()
                + " отклонено задание №" + id + ".");
        return "redirect:/admin/accepting";
    }

    @RequestMapping(value = "/addTask")
    public ModelAndView showAddTaskPage(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("addTask");
        modelAndView.addObject("plants", plantService.getAllPlants());
        modelAndView.addObject("workers", commonService.getAllWorkers());
        return modelAndView;
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addNewTask(@RequestParam(name = "plantId") String plantId,
                             @RequestParam(name = "workerId") String workerId,
                             @RequestParam(name = "purpose") String purpose,
                             @RequestParam(name = "description") String description,
                             @RequestParam(name = "number") String number,
                             Locale locale) {
        Order order = new Order(commonService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()),
                commonService.getUserById(Long.parseLong(workerId)),
                plantService.getPlantById(Long.parseLong(plantId)),
                number,
                purpose,
                description);
        adminService.addNewTask(order);
        log.info("Админом " + SecurityContextHolder.getContext().getAuthentication().getName()
                + " создано задание \"" + purpose + "\" для "
                + commonService.getUserById(Long.parseLong(workerId)) + ".");
        return "redirect:/login";
    }
}
