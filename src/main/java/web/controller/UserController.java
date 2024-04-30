package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/add-user")
    public String showAddUserForm(ModelMap model) {
//        model.addAttribute("cars", carService.getCars(Optional.ofNullable(count)));
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUser(@PathVariable("id") Long id, ModelMap model) {
//        model.addAttribute("cars", carService.getCars(Optional.ofNullable(count)));
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        userService.delete(id);
        return "redirect:/users";
    }
}
