package ru.shcegolev.courseproject.services;

import ru.shcegolev.courseproject.dto.UserDto;
import ru.shcegolev.courseproject.models.User;

import java.util.List;

public interface UserServices {
    String addUser(UserDto userDto);
    List<User> getAll(UserDto userDto);
    void deleteUser(Long userId);
   void updateUser(Long userId, UserDto userDto);
    User getUser(Long userId);
}
