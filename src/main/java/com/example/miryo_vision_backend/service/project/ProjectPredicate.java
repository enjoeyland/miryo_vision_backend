package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.entity.QProject;
import com.example.miryo_vision_backend.service.project.dto.ProjectSearchRequestDto;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;

@Component
public class ProjectPredicate {
    public static Predicate search(ProjectSearchRequestDto projectSearchRequestDto) {
        QProject project = QProject.project;
        BooleanBuilder builder= new BooleanBuilder();
        if (projectSearchRequestDto.getYear() != null) {
            builder.and(
                    project .year
                            .eq(YearEnum.findByName(projectSearchRequestDto.getYear()))
            );
        } if (projectSearchRequestDto.getCustomerCompanyId() != null) {
            builder.and(project.customerCompany.id.eq(Long.valueOf(projectSearchRequestDto.getCustomerCompanyId())));
        } if (projectSearchRequestDto.getSeason() != null) {
            builder.and(
                    project .season
                            .eq(SeasonEnum.findByName(projectSearchRequestDto.getSeason()))
            );
        } if (projectSearchRequestDto.getCustomerClassification() != null) {
            builder.and(
                    project .customerClassification
                            .eq(CustomerClassificationEnum.findByName(projectSearchRequestDto.getCustomerClassification()))
            );
        } if (projectSearchRequestDto.getGender() != null) {
            builder.and(
                    project .gender
                            .eq(GenderEnum.findByName(projectSearchRequestDto.getGender()))
            );
        } if (projectSearchRequestDto.getProductType() != null) {
            builder.and(
                    project .productType
                            .eq(ProductTypeEnum.findByName(projectSearchRequestDto.getProductType()))
            );
        }
        return builder;
    }
}
