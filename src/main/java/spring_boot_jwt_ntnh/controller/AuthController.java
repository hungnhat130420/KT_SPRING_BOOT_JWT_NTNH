package spring_boot_jwt_ntnh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_jwt_ntnh.entity.User;
import spring_boot_jwt_ntnh.service.UserSevice;

@RestController
public class AuthController {

    @Autowired
    private UserSevice userSevice;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userSevice.createUser(user);
    }

}
