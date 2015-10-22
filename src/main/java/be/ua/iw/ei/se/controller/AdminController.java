package be.ua.iw.ei.se.controller;

import be.ua.iw.ei.se.model.Permission;
import be.ua.iw.ei.se.model.Role;
import be.ua.iw.ei.se.model.User;
import be.ua.iw.ei.se.service.PermissionService;
import be.ua.iw.ei.se.service.RoleService;
import be.ua.iw.ei.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;
    @ModelAttribute("allUsers")
    public Iterable<User> populateUsers() {
        return this.userService.findAll();
    }

    @ModelAttribute("allRoles")
    public Iterable<Role> populateRoles() {
        return this.roleService.findAll();
    }

    @ModelAttribute("allPermissions")
    public Iterable<Permission> populatePermissions() {
        return this.permissionService.findAll();
    }

    @ModelAttribute("newUser")
    public User newUser(String userName, String password, String firstName, String lastName) {
        return new User(userName, password, firstName, lastName);
    }

    @ModelAttribute("newRole")
    public Role newRole(String name) {
        return new Role(name);
    }

    @RequestMapping({"/admin"})
    @PreAuthorize("hasRole('administrator')")
    public String showAdmin() {
        return "admin";
    }

    @RequestMapping(value = "/admin", params = {"user"})
    public String saveUser(final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        this.userService.add(user);
        model.clear();
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin", params = {"role"})
    public String saveRole(final Role role, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        this.roleService.add(role);
        model.clear();
        return "redirect:/admin";
    }


}
