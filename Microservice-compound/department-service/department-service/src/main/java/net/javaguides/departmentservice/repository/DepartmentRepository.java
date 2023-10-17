package net.javaguides.departments.service.repository;

import net.javaguides.departmentservice.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Long>{

  Department findByDepartment(String departmentCode);
}
