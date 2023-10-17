package net.javaguides.employeeservice.service.impl;

import lombok.AllArgsConstructor;

import net.javaguides.employeeeservice.dto.EmployeeDto;

import net.javaguides.employeeservice.repository.EmployeeRepository;

import net.javaguides.employeeservice.service.EmployeeService;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService{

  private.EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto){

    Employee employee = new Employee(
      employeeDto.getId(),
      employeeDto.getFirstName(),
      employeeDto.getLastName(),
      employeeDto.getEmail()
    );
    Employee savedEmployee = employeeRepository.save(employee);

    EmployeeDto savedEmployeeDto = new EmployeeDto(
      savedEmployee.getId(),
      savedEmployee.getFirstName(),
      savedEmployee.getLastName(),
      savedEmployee.getEmail();

    );
    return savedEmployeeDto;
  }

  @Override
  public EmployeeDto getEmployeeById(Long employeeId){

    Employee employee = employeeRepository.findById(employeeId).get();
    Employee employeeDto = new EmployeeDto(
      employee.getId(),
      employee.getFirstName(),
      employee.getLastName(),
      employee.getEmail()
    );
      return employeeDto;
  }
}
