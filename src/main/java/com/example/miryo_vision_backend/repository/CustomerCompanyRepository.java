package com.example.miryo_vision_backend.repository;

import com.example.miryo_vision_backend.entity.CustomerCompany;
import com.example.miryo_vision_backend.entity.project_select.CustomerClassificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.loading.MLetContent;

public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany, String> {
    CustomerCompany findByName(String name);
}
