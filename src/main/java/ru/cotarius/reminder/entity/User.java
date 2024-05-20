package ru.cotarius.reminder.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Entity
@Table(name = "users")
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be valid")
    @Column(name = "email")
    private String email;

    @Column(name = "telegram_id")
    private String telegramId;

    @NotEmpty(message = "name should not be empty")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "password should not be empty")
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(String.class, "username", new StringTrimmerEditor(true));
//    }
}
