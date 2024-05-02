package ru.cotarius.reminder.security;//package ru.cotarius.reminder.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import ru.cotarius.reminder.entity.User;
//import ru.cotarius.reminder.repository.UserRepository;
//import ru.cotarius.reminder.service.UserService;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("Ищем " + username);
//        User user = userRepository.findByUsername(username).orElseThrow(() ->
//                new UsernameNotFoundException("Пользователь " + username + " не найден"));
//        System.out.println("нашли " + user);
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                user.getPassword(), List.of(
//                        new SimpleGrantedAuthority(user.getRole())
//        ));
//    }
//}
