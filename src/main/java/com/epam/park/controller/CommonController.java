package com.epam.park.controller;

import com.epam.park.model.User;
import com.epam.park.model.roles.UserRoleEnum;
import com.epam.park.service.api.CommonService;
import com.epam.park.service.impl.security.UserDetailsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class CommonController {

    private static final Logger log = Logger.getLogger(CommonController.class);

    @Autowired
    CommonService commonService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/")
    public String showTitlePage(Locale locale) {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login")
    public String showLoginPage(Locale locale) {
        if (isCurrentAuthenticationAnonymous()) {
            log.info("Неавторизованный пользователь перешел на страницу логина.");
            return "title";
        }
        else {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            String role = commonService.getUserRole(userName);
            log.info("Пользователь авторизовался под именем " + userName + " и ролью " + role + ".");
            if (role.equals(UserRoleEnum.ROLE_USER.name())) return "redirect:/user";
            if (role.equals(UserRoleEnum.ROLE_ADMIN.name())
                    || role.equals(UserRoleEnum.ROLE_SUPER_ADMIN.name())) return "redirect:/admin";
            return "title";
        }
    }

    @RequestMapping(value = "/logout")
    public String showLogoutPage(Locale locale) {
        return "redirect:/";
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public @ResponseBody boolean checkEmail(@RequestParam(name = "email") String email, Locale locale) {
        return commonService.isEmailFree(email);
    }

    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public @ResponseBody String checkUser(@RequestParam(name = "email") String email,
                                          @RequestParam(name = "password") String password,
                                          Locale locale) {
        if (commonService.isEmailFree(email)) return "no such user";
        if (commonService.isPasswordCorrect(email, password)) return "submit";
        else return "incorrect password";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUserToDatabase(@RequestParam(name = "email") String email,
                                    @RequestParam(name = "name") String name,
                                    @RequestParam(name = "surname") String surname,
                                    @RequestParam(name = "password") String password,
                                    HttpServletRequest request,
                                    HttpServletResponse response,
                                    Locale locale) {
        commonService.saveUser(new User(UserRoleEnum.ROLE_USER.name(), email, password, name, surname));
        authenticateUserAndSetSession(email, password, request);
        log.info("Зарегистрировался новый пользователь под именем: " + email + ".");
        return "redirect:/user";
    }

    private void authenticateUserAndSetSession(String email, String password, HttpServletRequest request) {
        // generate session if one doesn't exist
        request.getSession();

        UserDetails user = userDetailsService.loadUserByUsername(email);
        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication instanceof AnonymousAuthenticationToken;
    }
}
