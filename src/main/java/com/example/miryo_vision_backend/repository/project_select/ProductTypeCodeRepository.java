package com.example.miryo_vision_backend.repository.project_select;

import com.example.miryo_vision_backend.entity.project_select.ProductTypeCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.loading.MLetContent;

public interface ProductTypeCodeRepository extends JpaRepository<ProductTypeCode, String> {
    ProductTypeCode findByName(String name);
}
