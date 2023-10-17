package net.javaguides.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://localhost:8080",value = "DEPARTMENT-SERVICE")

public interface APIClient {

  @GetMapping("api/departments/{department-code}")

  public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code")String departmentCode){
    DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
    return newResponseEntity<>(departmentDto,HttpStatus.OK);
  }
}
