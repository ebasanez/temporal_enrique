package com.viu.giin21.controller;

import com.viu.giin21.dto.UserDTO;
import com.viu.giin21.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ModelAndView index() {
        List<UserDTO> users = service.findAll();
        return new ModelAndView("user/index", "users", users);
    }

    @GetMapping("/create")
    public ModelAndView create_GET() {
        UserDTO user = new UserDTO(null, "", "", "");
        return new ModelAndView("user/create", "user", user);
    }

    @PostMapping("/create")
    public String create_POST(UserDTO user) {
        service.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit_GET(@PathVariable Integer id) {
        UserDTO userDto = service.get(id);
        return new ModelAndView("user/edit", "user", userDto);
    }

    @PostMapping("/{id}/edit")
    public String edit_POST(@PathVariable Integer id, UserDTO user) {
        user.setId(id);
        service.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete_GET(@PathVariable Integer id) {
        UserDTO userDto = service.get(id);
        return new ModelAndView("user/delete", "user", userDto);
    }

    @PostMapping("/{id}/delete")
    public String delete_POST(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/user";
    }
}
