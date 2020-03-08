package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.entity.QProject;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;

@Component
public class ProjectPredicate {
    public static Predicate search(ProjectDto.Request.Search projectSearchRequest) {
        QProject project = QProject.project;
        BooleanBuilder builder= new BooleanBuilder();
        if (projectSearchRequest.getYear() != null) {
            builder.and(
                    project .year
                            .eq(projectSearchRequest.getYear())
            );
        } if (projectSearchRequest.getCustomerCompanyId() != null) {
            builder.and(project.customerCompany.id.eq(projectSearchRequest.getCustomerCompanyId()));
        } if (projectSearchRequest.getSeason() != null) {
            builder.and(
                    project .season
                            .eq(projectSearchRequest.getSeason())
            );
        } if (projectSearchRequest.getCustomerClassification() != null) {
            builder.and(
                    project .customerClassification
                            .eq(projectSearchRequest.getCustomerClassification())
            );
        } if (projectSearchRequest.getGender() != null) {
            builder.and(
                    project .gender
                            .eq(projectSearchRequest.getGender())
            );
        } if (projectSearchRequest.getProductType() != null) {
            builder.and(
                    project .productType
                            .eq(projectSearchRequest.getProductType())
            );
        }
        return builder;
    }
}
