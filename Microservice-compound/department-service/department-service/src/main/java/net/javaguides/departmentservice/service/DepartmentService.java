package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

  DepartmentDto saveDepartment(DepartmentDto departmemtDto);

  DepartmentDto getDepartmentByCode(String code);
}
