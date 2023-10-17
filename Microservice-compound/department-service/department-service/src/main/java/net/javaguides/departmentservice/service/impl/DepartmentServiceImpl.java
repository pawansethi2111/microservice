package net.javaguides.departmentservice.service.impl;

import net.javaguides.departmentservice.service.DepartmentService;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.AutoWired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class DepartmentServiceImpl implements DepartmentService{

  private DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository){
    this.departmentRepository = departmentRepository;
  }

  @Override
  public DepartmentDto saveDepartment(DepartmentDto department Dto){

    Department department = new Department(
      departmentDto.getId(),
      departmentDto.getDepartmentName(),
      departmentDto.getDepartmentDescription(),
      departmentDto.getDepartmentCode()
    );

    Department savedDepartment = departmentRepository.save(department);

    DepartmentDto savedDepartmentDto = new DepartmentDto(){
      savedDepartment.getId(),
      savedDepartment.getDepartmentName(),
      savedDepartment.getDepartmentDescription(),
      savedDepartment.getDepartmentCode(),

    }
      return savedDepartmentDto;
  }

  @Override
  public DepartmentDto getDepartmentByCode(String departmentCode){
    Department department = departmentRepository.findByDepartmentCode(departmentCode);

    DepartmentDto departmentDto = new DepartmentDto(
        department.getId();
        department.getDepartmentName(),
        department.getDepartmentDescription(),
        department.getDepartmentCode()
    );
    return departmentDto;
  }
}
