package ru.shcegolev.courseproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.shcegolev.courseproject.dto.UserDto;
import ru.shcegolev.courseproject.services.UserServices;

@Controller
@RequiredArgsConstructor
public class RegisterUserController {
    private final UserServices userServices;
    @GetMapping("register")
    public String getRegistrationPage(){
        return "register";
    }
    @PostMapping("register")
    public String getRegistrationUser(@ModelAttribute UserDto userDto){
        String dataForValid = userServices.addUser(userDto);
        System.out.println(dataForValid);


        return "redirect:/home";
    }
}
