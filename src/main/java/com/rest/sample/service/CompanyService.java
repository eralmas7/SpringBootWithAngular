package com.rest.sample.service;

import java.util.List;
import com.rest.sample.model.Company;

/**
 * A service which would be responsible to save company or retrieve the company from storage
 * repository.
 */
public interface CompanyService {

    /**
     * Returns the instance of company associated with a particular companyId.
     * 
     * @param companyId
     * @return
     */
    public Company getCompany(final Long companyId);

    /**
     * Returns all the companies registered till now.
     * 
     * @return
     */
    public List<Company> getAllCompanies();

    /**
     * Update a company into storage media.
     * 
     * @param company
     * @return
     */
    public Company updateCompany(final Company company);

    /**
     * Register a new company with storage media.
     * 
     * @param company
     * @return
     */
    public Company addCompany(final Company company);

    /**
     * Delete a record of a particular company.
     * 
     * @param companyId
     */
    public void deleteCompany(final Long companyId);
}
