package com.example.miryo_vision_backend.repository.project_select;

import com.example.miryo_vision_backend.entity.project_select.YearCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearCodeRepository extends JpaRepository<YearCode, String> {
    YearCode findByName(String name);
}
