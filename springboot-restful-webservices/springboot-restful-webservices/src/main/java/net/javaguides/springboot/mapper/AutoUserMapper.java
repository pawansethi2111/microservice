package javaguides.springboot.mapper;
//import javaguides.springboot.entity.User;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import org.mapStruct.Mapper;
import org.mapStruct.Mapping;

@Mapper
public interface AutoUserMapper {

  //
  // @Mapping(source = "email" , target  = "emailAddress")
  AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
  UserDto mapToUserDto(User user);

  User mapToUser(UserDto userDto);
}
