package com.example.miryo_vision_backend.repository;

import com.example.miryo_vision_backend.entity.Employee;
import com.example.miryo_vision_backend.service.employee.enums.DepartmentEnum;
import com.example.miryo_vision_backend.service.employee.enums.JobDutyEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentAndJobDuty (DepartmentEnum department, JobDutyEnum jobDuty);
}
