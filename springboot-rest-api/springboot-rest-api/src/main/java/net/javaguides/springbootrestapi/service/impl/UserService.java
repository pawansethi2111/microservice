package net.javaguides.springbootrestapi.service.impl;

import net.javaguides.springboot.entity.User;

public interface UserService {
  User createUser(User user);

  User getUserId(Long userId);

  List<User>getAllUsers();
}
