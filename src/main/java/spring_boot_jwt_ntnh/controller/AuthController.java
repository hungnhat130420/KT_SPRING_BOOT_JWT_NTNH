package spring_boot_jwt_ntnh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_jwt_ntnh.authen.UserPrincipal;
import spring_boot_jwt_ntnh.entity.Token;
import spring_boot_jwt_ntnh.entity.User;
import spring_boot_jwt_ntnh.service.TokenService;
import spring_boot_jwt_ntnh.service.UserSevice;
import spring_boot_jwt_ntnh.util.JwtUtil;

@RestController
public class AuthController {

    @Autowired
    private UserSevice userSevice;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userSevice.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userSevice.findByUsername(user.getUsername());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }

        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }


}
