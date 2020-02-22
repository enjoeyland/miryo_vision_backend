package com.example.miryo_vision_backend.repository.project_select;

import com.example.miryo_vision_backend.entity.project_select.GenderCode;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.loading.MLetContent;

public interface GenderCodeRepository extends JpaRepository<GenderCode, String> {
    GenderCode findByName(String name);
}
