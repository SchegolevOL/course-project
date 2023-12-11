package ru.shcegolev.courseproject.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shcegolev.courseproject.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByLogin(String login);
    User findByEmail(String email);
}
