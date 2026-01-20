package com.embarkx.companyms.company.impl;


import com.embarkx.companyms.company.Company;
import com.embarkx.companyms.company.CompanyRepository;
import com.embarkx.companyms.company.CompanyService;
import com.embarkx.companyms.company.clients.ReviewClient;
import com.embarkx.companyms.company.dto.ReviewMessage;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository,ReviewClient reviewClient) {
        this.companyRepository = companyRepository;
        this.reviewClient=reviewClient;
    }

    @Override
    public List<Company> gelAllCompanies() {
         return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company comapny, Long id) {
        Optional<Company> companyOptional=  companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyToUpdate=companyOptional.get();
            companyToUpdate.setName(comapny.getName());
            companyToUpdate.setDescription(comapny.getDescription());
            companyRepository.save(companyToUpdate);

            return true;


        }else
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteComapnyByid(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
          return true;
        }
        else
            return false;

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        Company company= companyRepository.findById(reviewMessage.getCompanyId()).orElseThrow
                (()-> new NotFoundException("Company Not Found "+reviewMessage.getCompanyId()));

        double averageRating=reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
        company.setRating(averageRating);
        companyRepository.save(company);

    }

}
