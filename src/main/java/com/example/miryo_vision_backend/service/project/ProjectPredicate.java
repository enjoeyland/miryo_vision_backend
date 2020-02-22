package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.entity.QProject;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class ProjectPredicate {
    public static Predicate search(ProjectCodeNameDto projectCodeNameDto) {
        QProject project = QProject.project;
        BooleanBuilder builder= new BooleanBuilder();
        if (projectCodeNameDto.getYearCodeName() != null) {
            builder.and(project.yearCodeName.eq(projectCodeNameDto.getYearCodeName()));
        } if (projectCodeNameDto.getCustomerCompanyName() != null) {
            builder.and(project.customerCompany.name.eq(projectCodeNameDto.getCustomerCompanyName()));
        } if (projectCodeNameDto.getSeasonCodeName() != null) {
            builder.and(project.seasonCodeName.eq(projectCodeNameDto.getSeasonCodeName()));
        } if (projectCodeNameDto.getCustomerClassificationCodeName() != null) {
            builder.and(project.customerClassificationCodeName.eq(projectCodeNameDto.getCustomerClassificationCodeName()));
        } if (projectCodeNameDto.getGenderCodeName() != null) {
            builder.and(project.genderCodeName.eq(projectCodeNameDto.getGenderCodeName()));
        } if (projectCodeNameDto.getProductTypeCodeName() != null) {
            builder.and(project.productTypeCodeName.eq(projectCodeNameDto.getProductTypeCodeName()));
        }
        return builder;
    }
}
