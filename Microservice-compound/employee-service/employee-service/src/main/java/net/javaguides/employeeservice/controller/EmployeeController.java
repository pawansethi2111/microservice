package net.javaguides.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeesservice.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor

public class  EmployeeController{
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeDto>saveEmployee(@RequestBody EmployeeDto employeeDto){
    EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<APIResponseDto> getEmployee(@PathVariable ("id") Long employeeId){
    APIResponseDto apiResponseDto= employeeService.getEmployeeById(employeeId);
    return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
  }
}
