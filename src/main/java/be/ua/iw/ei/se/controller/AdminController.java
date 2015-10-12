package be.ua.iw.ei.se.controller;

import be.ua.iw.ei.se.model.Role;
import be.ua.iw.ei.se.model.User;
import be.ua.iw.ei.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by seb on 10/9/2015.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @ModelAttribute("allUsers")
    public List<User> populateUsers() {
        return this.userService.findAll();
    }
    @ModelAttribute("allRoles")
    public List<Role> populateRoles() {
        return this.userService.getRoles();
    }
    @RequestMapping({"/", "/home"})
    @PreAuthorize("hasRole('administrator')")
    public String showAdmin() {
        return "admin";
    }


}
