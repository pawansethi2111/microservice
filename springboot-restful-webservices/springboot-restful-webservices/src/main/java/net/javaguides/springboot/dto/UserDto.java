package javaguides.springboot.dto;


import lombok.Getter;
import lombok.Setter;

@Schema(
  description = "UserDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
  private Long id;

  @Schema(
    description = "User First Name"
  )

  @NotEmpty(message = "User first name should not be null or empty")
  private String firstName;

  @Schema(
    description = "User Last Name"
  )

  @NotEmpty(message = "User last name should not be null or empty")
  private String lastName;

  @Schema(
    description: "User Email Address"
  )
  @NotEmpty(message = "User mail should not be null or empty")
  @Email(message = "Email address should be valid")
  private String email;

}
