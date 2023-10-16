package javaguides.springboot.controller;

import javaguides.springboot.exception.ErrorDetails;
import lombok.AllArgsController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Tag(
  name = "CRUD REST APIs for User Resource",
  description = "CRUD REST APIs  - Create User, Update user, Get User, Get All Users, Delete User"
)

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

  private UserService userService;

  @Operation(
    summary = "Create User REST API",
    description  = "Create User Rest API is usedd to save user in a database"
  )

  @ApiResponse(
    responseCode = "201",
    description = "HTTP Status 201 CREATED"
  )

  @PostMapping
  public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
  {
    UserDto savedUser  =  userService.createUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }


  @Operation(
    summary = "Get User by ID REST API",
    description  = "Get User by ID REST API is used to get a single user from the database"
  )

  @ApiResponse(
    responseCode = "200",
    description = "HTTP Status 200 SUCCESS"
  )



  //build get user by id REST API
  //http://localhost:8080/api/users/1
  @GetMapping("{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
    UserDto user = userService.getUserById(userId);
    return new ResponseEntity<>(user,HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers()
  {
    List<UserDto > users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @Operation(
    summary = "Get All Users REST API",
    description  = "Update User REST API is used to update a particular user in the database"
  )
  @ApiResponse(
    responseCode = "200",
    description = "HTTP Status 200 SUCCESS"
  )

  @PutMapping("{id}")
  public ResponseEntity<User>updateUser(@PathVariable("id") Long userId,@RequestBody @Valid UserDto user){
    user.setId(userId);
    UserDto updatedUser  = userService.updateUser(user);
     return new ResponseEntity<>(updatedUser, HttpStatus.OK);
  }

  @Operation(
    summary = "Delete User REST API",
    description = "Delete User REST API is used to delete a particular user from the database"
  )

  @ApiResponse(
    responseCode ="200",
    description = "HTTP Status 200 SUCCESS"
  )

  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
    userService.deleteUser(userId);
    return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
  }

//  @ExceptionHandler(ResourceNotFoundException.class)
//  public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                      WebRequestwebrequest){
//    ErrorDetails errorDetails = new ErrorDetails(
//      LocalDateTime.now(),
//      exception.getMessage(),
//      webRequest.getDescription(includeClientInfo: false),
//    errorCode:"USER_NOT_FOUND"
//    );
//    return new ResponsEntity<>(erroDetails, HttpStatus.NOT_FOUND);
//  }
}


