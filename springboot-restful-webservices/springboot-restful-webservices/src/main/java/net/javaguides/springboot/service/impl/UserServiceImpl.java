package javaguides.springboot.service.impl;

import javaguides.springboot.dto.UserDto;
import javaguides.springboot.entity.User;
import javaguides.springboot.exception.ResourceNotFoundException;
import javaguides.springboot.mapper.AutoUserMapper;
import javaguides.springboot.mapper.UserMapper;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.exception.EmailAlreadyExistsException;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  private UserRepository userRepository;

  private ModelMapper modelMapper;

  @Override
  public UserDto createUser(UserDto userDto) {

    //User user1 = UserMapper.mapToUser(userDta);

    Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

    if(optionalUser.isPresent()){
        throw new EmailAlreadyExistsException("Email Already exists for user");
    }
    //User user = modelMapper.map(userDto, User.class);
    User user = AutoUserMapper.MAPPER.mapToUser(userDto);
    User savedUser = userRepository.save(user);

    UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

    return savedUserDto;
  }
  @Override
    public UserDto getUserById(Long userId){

    user User = userRepository.findById(userId).orElseThrow(
      () ->   new ResourceNotFoundException("User",  "id", userId)
    );
   User user  =  optionalUser.get();
   //return UserMapper.mapToUserDto(user);
    //return modelMapper.map(user, UserDto.class);
    return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
    }

    @Override
  public List<UserDto> getAllUsers(){
    return userRepository.findAll();
    //return user.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

    //return users.stream().map((user)->modelMapper(user,userDto.class)).collect(Collectors.toList());
      return users.stream().map((user) -> AutoMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user){
      User existingUser = userRepository.findById(user.getId()).orElseThrow(
        () -> new ResourceNotFoundException("User", "id", user.getId())
      );
      existingUser.setFirstName(user.getFirstName());
      existingUser.setLastName(user.getLastName());
      existingUser.setEmail(user.getEmail());
      User updatedUser = userRepository.save(existingUser);
      //return UserMapper.mapToUserDto(updatedUser);
      //return modelMapper.map(updatedUser UserDto.class);
      return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId){

      User existingUser = userRepository.findById(userId).orElseThrow(
        () -> new ResourceNotFoundException("User", "id", userId)
      );
      userRepository.deleteById(userId);
    }

}
