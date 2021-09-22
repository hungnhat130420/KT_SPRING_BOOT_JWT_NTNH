package spring_boot_jwt_ntnh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_jwt_ntnh.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
