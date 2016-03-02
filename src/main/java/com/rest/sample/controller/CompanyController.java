package com.rest.sample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.rest.sample.model.Company;
import com.rest.sample.service.CompanyService;

/**
 * Spring's rest controller which will expose rest api's for the assignment.
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * Get all the companies registered with this application.
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "{companyId}")
    public Company getCompany(final @PathVariable Long companyId) {
        return companyService.getCompany(companyId);
    }

    /**
     * Delete the company details associated with this application.
     * 
     * @param companyId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "{companyId}")
    public ResponseEntity<?> deleteCompany(final @PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(companyId).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

    /**
     * Get all the companies submitted in this application.
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /**
     * Update an existing company.
     * 
     * @param companyId
     * @param company
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "{companyId}")
    public ResponseEntity<Company> updateCompany(final @PathVariable Long companyId, final @RequestBody Company company) {
        final Company savedCompany = companyService.updateCompany(company);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCompany.getCompanyId()).toUri());
        return new ResponseEntity<Company>(savedCompany, httpHeaders, HttpStatus.OK);
    }

    /**
     * Add a new company.
     * 
     * @param company
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Company> addCompany(final @RequestBody Company company) {
        final Company savedCompany = companyService.addCompany(company);
        final HttpHeaders httpHeaders = new HttpHeaders();// could ask to cache the response!
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCompany.getCompanyId()).toUri());
        return new ResponseEntity<Company>(savedCompany, httpHeaders, HttpStatus.CREATED);
    }
}
