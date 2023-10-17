package net.javaguides.employeeservice.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto{

  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String departmentCode;
}
