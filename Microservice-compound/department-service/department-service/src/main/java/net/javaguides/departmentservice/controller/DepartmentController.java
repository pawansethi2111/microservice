package net.javaguides.departmentservice.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor

public class DepartmentController{
  private DepartmentService departmentService;


  //public DepartmentController(DepartmentService departmentService){
    //this.departmentService = departmentService;
  @PostMapping
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto,departmentDto){
    DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

    return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
  }

  @GetMapping("{department-code}")
  public ResponseEntity<DepartmentDto> getDepartment( @PathVariable("department-code")String departmentCode){
    DepartmentDto departmentDto= departmentService.getDepartmentByCode(departmentCode);
    return new ResponseEntity<>(departmentDto,HttpStatus.OK);

  }
}
