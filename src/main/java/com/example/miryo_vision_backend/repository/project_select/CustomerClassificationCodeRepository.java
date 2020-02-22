package com.example.miryo_vision_backend.repository.project_select;

import com.example.miryo_vision_backend.entity.project_select.CustomerClassificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.loading.MLetContent;

public interface CustomerClassificationCodeRepository extends JpaRepository<CustomerClassificationCode, String> {
    CustomerClassificationCode findByName(String name);
}
