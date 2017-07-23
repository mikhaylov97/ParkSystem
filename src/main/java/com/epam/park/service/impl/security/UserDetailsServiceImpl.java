package com.epam.park.service.impl.security;

import com.epam.park.model.User;
import com.epam.park.model.roles.UserRoleEnum;
import com.epam.park.service.api.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    CommonService commonService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        User user = commonService.getUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException("No such user");
        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();
        if (user.getRole().equalsIgnoreCase(UserRoleEnum.ROLE_ADMIN.name())) {
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_ADMIN.name()));
        } else if (user.getRole().equalsIgnoreCase(UserRoleEnum.ROLE_USER.name())) {
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.name()));
        }

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), roles);

        return userDetails;
    }
}
