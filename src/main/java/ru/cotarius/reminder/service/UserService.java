package ru.cotarius.reminder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.cotarius.reminder.entity.Role;
import ru.cotarius.reminder.entity.User;
import ru.cotarius.reminder.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser (User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEmail(passwordEncoder.encode(user.getEmail()));
//        user.setTelegramId(passwordEncoder.encode(user.getTelegramId()));
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(String login) {
        return userRepository.findByUsername(login).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Нет такого пользователя с login " + login));
    }

    /**
     * Поиск пользователя по google id в репозитории. Если пользователь существует - то он возвращается. Иначе - создается новый
     * @param googleId google id пользователя
     * @param email email пользователя
     * @return пользователь
     */
    public User findByGoogleIdOrCreateNew(String googleId, String email) {
        Optional<User> userOptional = userRepository.findByGoogleId(googleId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setRole(Role.USER);
            newUser.setUsername(googleId.toLowerCase());
            newUser.setName(googleId.toLowerCase());

            userRepository.save(newUser);
            return newUser;
        }
    }
}
