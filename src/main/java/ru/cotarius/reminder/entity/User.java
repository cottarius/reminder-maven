package ru.cotarius.reminder.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "telegram_id")
    private long telegramId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

//    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private String role;
//    private Role role;


}
