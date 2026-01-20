package com.embarkx.companyms.company;

import com.embarkx.companyms.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {

    List<Company> gelAllCompanies();

    boolean updateCompany(Company comapny,Long id);
    void createCompany(Company company);
    boolean deleteComapnyByid(Long id);
    Company getCompanyById(Long id);
    public void updateCompanyRating(ReviewMessage reviewMessage);


}
