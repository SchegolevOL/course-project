package ru.shcegolev.courseproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {
    @NotEmpty
    @Length(min=1,max=10)
    private String name;
    @NotEmpty
    @Length(min=1,max=10)
    private String login;
    @NotEmpty
    @Length(min=3)
    private String password;
    @NotEmpty
    @Length(min=3)
    private String email;
}
