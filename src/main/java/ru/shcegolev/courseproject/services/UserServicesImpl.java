package ru.shcegolev.courseproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shcegolev.courseproject.dto.UserDto;
import ru.shcegolev.courseproject.models.User;
import ru.shcegolev.courseproject.repositorys.UserRepository;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;    todo add security

    @Override
    public String addUser(UserDto userDto) {
        User checkedUsernameByUsername = userRepository.findByLogin(userDto.getLogin());
        User checkedUsernameByEmail = userRepository.findByEmail(userDto.getEmail());
        if(checkedUsernameByUsername != null && checkedUsernameByEmail != null){
            return "notUniqueUsernameAndEmail";
        }

        if(checkedUsernameByUsername != null){
            return "notUniqueUsername";
        }

        if(checkedUsernameByEmail != null){
            return "notUniqueEmail";
        }
        User buildetUser = User.builder()
                .name(userDto.getName())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .role(User.Role.USER)
                .createdStamp(new Timestamp(System.currentTimeMillis()))
                .updateStamp(new Timestamp(System.currentTimeMillis()))
                .build();
        userRepository.save(buildetUser);
        return "success";

    }

    @Override
    public List<User> getAll(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public void updateUser(Long userId, UserDto userDto) {

    }

    @Override
    public User getUser(Long userId) {
        return null;
    }
}
