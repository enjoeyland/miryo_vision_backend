package com.example.miryo_vision_backend.entity.project_select;

import com.example.miryo_vision_backend.entity.Code;
import com.example.miryo_vision_backend.entity.Project;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "YEAR_CODE")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class YearCode extends Code {
    public YearCode(String name, String code, String sort, String note) {
        super(name, code, sort, note);
    }

}
