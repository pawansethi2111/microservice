package net.javaguides.springbootrestapi.service.impl;

public class UserServiceImpl implements UserService{

  private UserRepository userRepository;


  @Override
  public User createUser(User user){
    return userRepository.save(user);
  }

  @Override
  public User getUSerById(Long userId){
    Optional<User>optionalUser.get();
  }
  @Override
  public List<User> getAllUsers(){
    return userRepository.findAll();
  }
}
