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

 // private WebClient webClient;

  //private RestTemplate restTemplate;

  private APIClient apiClient;

  @Override

  public EmployeeDto saveEmployee(EmployeeDto employeeDto){

    Employee employee = employeeRepository.findById(employeeId).get();
//
//    ResponseEntity<DepartmentDto> restTemplate.getForEntity(url: "https://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//
//    DepartmentDto departmentDto = responseEntity.getBody();

//    DepartmentDto departmentDto = webClient.get()
//      .uri(uri:"https://localhost:8080/api/departments/"+ employee.getDepartmentCode())
//      .retrieve()
//      .bodyToMono(DepartmentDto.class)
//      .block();

    DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

    EmployeeDto employeeDto = new EmployeeDto(
      employeeDto.getId(),
      employeeDto.getFirstName(),
      employeeDto.getLastName(),
      employeeDto.getEmail(),
      employeeDto.getDepartmentCode()
    );
    Employee savedEmployee = employeeRepository.save(employee);

    EmployeeDto savedEmployeeDto = new EmployeeDto(
      savedEmployee.getId(),
      savedEmployee.getFirstName(),
      savedEmployee.getLastName(),
      savedEmployee.getEmail();
      savedEmployee.getDepartmentCode()

    );

    return savedEmployeeDto;
  }

  @Override
  public APIResponseDto getEmployeeById(Long employeeId){

    Employee employee = employeeRepository.findById(employeeId).get();
    Employee employeeDto = new EmployeeDto(
      employee.getId(),
      employee.getFirstName(),
      employee.getLastName(),
      employee.getEmail()
    );

    APIResponseDto apiResponseDto = new APIResponseDto();
    apiResponseDto.setEmployee(employeeDto);
    apiResponseDto.setDepartment(departmentDto);

    return apiResponseDto;
  }
}
