package spring_boot_jwt_ntnh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot_jwt_ntnh.entity.Token;
import spring_boot_jwt_ntnh.repository.TokenRepository;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}
