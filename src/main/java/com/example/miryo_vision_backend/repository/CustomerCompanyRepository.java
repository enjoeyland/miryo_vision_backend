package com.example.miryo_vision_backend.repository;

import com.example.miryo_vision_backend.entity.CustomerCompany;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerCompanyRepository extends JpaRepository<CustomerCompany, Long> {
    CustomerCompany findByName(String name);
}
