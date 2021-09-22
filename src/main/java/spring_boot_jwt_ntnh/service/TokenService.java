package spring_boot_jwt_ntnh.service;

import spring_boot_jwt_ntnh.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
