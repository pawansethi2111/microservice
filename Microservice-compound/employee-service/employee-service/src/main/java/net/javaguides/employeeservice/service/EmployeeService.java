package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService{

  EmployeeDto saveEmployee(EmployeeDto employeeDto);

  APIResponseDto getEmployeeById(Long employeeId);
}
