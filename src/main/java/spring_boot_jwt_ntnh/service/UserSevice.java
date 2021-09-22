package spring_boot_jwt_ntnh.service;

import spring_boot_jwt_ntnh.authen.UserPrincipal;
import spring_boot_jwt_ntnh.entity.User;

public interface UserSevice {
  public User createUser(User user);
  public UserPrincipal findByUsername(String username);
}
