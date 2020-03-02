package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.entity.CustomerCompany;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.repository.CustomerCompanyRepository;
import com.example.miryo_vision_backend.service.DateInfoCreator;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeDto;
import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectInfoCreator extends DateInfoCreator {

    private CustomerCompanyRepository customerCompanyRepository;

    @Autowired
    public ProjectInfoCreator(CustomerCompanyRepository customerCompanyRepository) {
        this.customerCompanyRepository = customerCompanyRepository;
    }

    public String getProjectName(Project project) {
        return  project.getYear().getName() + "년도 " +
                project.getCustomerCompany().getName() + " " +
                project.getSeason().getName() + " " +
                project.getGender().getName() + "복 ";

    }


    public CustomerCompany getCustomerCompany(Long customerCompanyID) {
        return customerCompanyRepository.findById(customerCompanyID).orElse(null);
    }

    public String getProjectBarcode(ProjectCodeDto projectCodeDto, Long projectId) {
        return  projectCodeDto.getCustomerClassificationCode() +
                projectCodeDto.getYearCode() +
                String.format("%02d",  Integer.parseInt(projectCodeDto.getCustomerCompanyCode())).substring(0, 2) +
                projectCodeDto.getGenderCode() +
                projectCodeDto.getSeasonCode() +
                projectCodeDto.getProductTypeCode() +
                String.format("%03d", projectId).substring(0, 3);

    }

    public String getProjectPlantCode(ProjectCodeDto projectCodeDto, Long projectId) {
        return  projectCodeDto.getYearCode() +
                "-" +
                String.format("%03d", projectId).substring(0, 3);

    }
}
