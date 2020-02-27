package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.entity.QProject;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;

@Component
public class ProjectPredicate {
    public static Predicate search(ProjectCodeNameDto projectCodeNameDto) {
        QProject project = QProject.project;
        BooleanBuilder builder= new BooleanBuilder();
        if (projectCodeNameDto.getYear() != null) {
            builder.and(
                    project .year
                            .eq(YearEnum.findByName(projectCodeNameDto.getYear()))
            );
        } if (projectCodeNameDto.getCustomerCompanyName() != null) {
            builder.and(project.customerCompany.name.eq(projectCodeNameDto.getCustomerCompanyName()));
        } if (projectCodeNameDto.getSeason() != null) {
            builder.and(
                    project .season
                            .eq(SeasonEnum.findByName(projectCodeNameDto.getSeason()))
            );
        } if (projectCodeNameDto.getCustomerClassification() != null) {
            builder.and(
                    project .customerClassification
                            .eq(CustomerClassificationEnum.findByName(projectCodeNameDto.getCustomerClassification()))
            );
        } if (projectCodeNameDto.getGender() != null) {
            builder.and(
                    project .gender
                            .eq(GenderEnum.findByName(projectCodeNameDto.getGender()))
            );
        } if (projectCodeNameDto.getProductType() != null) {
            builder.and(
                    project .productType
                            .eq(ProductTypeEnum.findByName(projectCodeNameDto.getProductType()))
            );
        }
        return builder;
    }
}
