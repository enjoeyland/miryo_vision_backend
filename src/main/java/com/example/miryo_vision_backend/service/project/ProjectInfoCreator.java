package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.repository.project_select.*;
import com.example.miryo_vision_backend.service.DateInfoCreator;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectInfoCreator extends DateInfoCreator {

    private CustomerCompanyRepository customerCompanyRepository;
    private YearCodeRepository yearCodeRepository;
    private CustomerClassificationCodeRepository customerClassificationCodeRepository;
    private SeasonCodeListRepository seasonCodeListRepository;
    private ProductTypeCodeRepository productTypeCodeRepository;
    private GenderCodeRepository genderCodeRepository;

    @Autowired
    public ProjectInfoCreator(CustomerCompanyRepository customerCompanyRepository, YearCodeRepository yearCodeRepository, CustomerClassificationCodeRepository customerClassificationCodeRepository, SeasonCodeListRepository seasonCodeListRepository, ProductTypeCodeRepository productTypeCodeRepository, GenderCodeRepository genderCodeRepository) {
        this.customerCompanyRepository = customerCompanyRepository;
        this.yearCodeRepository = yearCodeRepository;
        this.customerClassificationCodeRepository = customerClassificationCodeRepository;
        this.seasonCodeListRepository = seasonCodeListRepository;
        this.productTypeCodeRepository = productTypeCodeRepository;
        this.genderCodeRepository = genderCodeRepository;
    }


    public Long getCustomerCompanyId(String customerCompanyName) {
        return customerCompanyRepository.findByName(customerCompanyName).getId();
    }

    public String getProjectBarcode(Project project) {

        ProjectCodeDto projectCodeDto = this.nameToCode(project);

        return  projectCodeDto.getCustomerClassificationCode() +
                projectCodeDto.getYearCode() +
                String.format("%02d",  Integer.parseInt(projectCodeDto.getCustomerCompanyCode())).substring(0, 2) +
                projectCodeDto.getGenderCode() +
                projectCodeDto.getSeasonCode() +
                projectCodeDto.getProductTypeCode() +
                String.format("%03d", project.getId()).substring(0, 3);

    }

    // todo: 다른 방법찾기
    private ProjectCodeDto nameToCode(Project project) {
        ProjectCodeDto projectCodeDto = new ProjectCodeDto();
        projectCodeDto.setYearCode(yearCodeRepository.findByName(project.getYearCodeName()).getCode());
        projectCodeDto.setCustomerClassificationCode(customerClassificationCodeRepository.findByName(project.getCustomerClassificationCodeName()).getCode());
        projectCodeDto.setCustomerCompanyCode(customerCompanyRepository.findByName(project.getCustomerCompany().getName()).getCode());
        projectCodeDto.setSeasonCode(seasonCodeListRepository.findByName(project.getSeasonCodeName()).getCode());
        projectCodeDto.setProductTypeCode(productTypeCodeRepository.findByName(project.getProductTypeCodeName()).getCode());
        projectCodeDto.setGenderCode(genderCodeRepository.findByName(project.getGenderCodeName()).getCode());
        return projectCodeDto;
    }
}
