package webAppl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webAppl.entity.User;
import webAppl.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("allUsers", userService.listUsers());
        return "HomePage";
    }

    @GetMapping("/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("userId")long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateView(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }
    @PostMapping("/update")
    public String confrimUpdate(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }



}
