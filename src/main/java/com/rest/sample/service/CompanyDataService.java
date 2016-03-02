package com.rest.sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rest.sample.model.Company;
import com.rest.sample.repository.CompanyRepository;

/**
 * Service to provide answer to company related queries i.e. all company or save company.
 */
@Service
@Transactional
public class CompanyDataService implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyDataService(final CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company getCompany(final Long companyId) {
        return companyRepository.findOne(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        // return companyRepository.getAllCompanies(new PageRequest(0, size);//pagination
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(final Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(final Long companyId) {
        companyRepository.delete(companyId);
    }

    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}
