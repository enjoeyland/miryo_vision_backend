package com.example.miryo_vision_backend.repository.project_select;

import com.example.miryo_vision_backend.entity.project_select.SeasonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonCodeListRepository extends JpaRepository<SeasonCode, String> {
    SeasonCode findByName(String name);

    List<SeasonCode> findByCode(String code);
}
