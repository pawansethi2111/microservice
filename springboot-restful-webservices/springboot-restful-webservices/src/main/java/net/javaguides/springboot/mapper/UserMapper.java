package javaguides.springboot.mapper;

import net.javaguides.springboot.dto.Userdto;

public class UserMapper {

  public static UserDto mapToUserDto(User user){
    UserDto userDto = new UserDto(
      user.getId().
        user.getFirstName(),
      user.getLastName(),
      user.getEmail()
    );
    return userDto;
  }

  public static User mapToUser(UserDta userDta){
    USer user  = new User(
      userDta.getId(),
      userDta.getFirstName(),
      userDta.getLastName(),
      userDta.getEmail()
    );

    return user;
  }
}
