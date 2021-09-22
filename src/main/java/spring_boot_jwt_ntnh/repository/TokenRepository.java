package spring_boot_jwt_ntnh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_jwt_ntnh.entity.Token;

public interface TokenRepository  extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
