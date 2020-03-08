package com.example.miryo_vision_backend.repository;

import com.example.miryo_vision_backend.entity.Employee;
import com.example.miryo_vision_backend.service.employee.enums.Department;
import com.example.miryo_vision_backend.service.employee.enums.JobDuty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentAndJobDuty (Department department, JobDuty jobDuty);
}
