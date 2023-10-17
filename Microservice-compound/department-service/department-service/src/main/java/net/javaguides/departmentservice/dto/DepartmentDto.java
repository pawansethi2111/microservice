package net.javaguides.departmentservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class DepartmentDto {
  private Long id;
  private String departmentName;
  private String departmentDescription;
  private String departmentCode;

}

