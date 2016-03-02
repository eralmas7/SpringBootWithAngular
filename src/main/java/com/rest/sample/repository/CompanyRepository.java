package com.rest.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rest.sample.model.Company;

/**
 * Repository which will be used to store company details to storage media.
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("FROM Company company WHERE company.name = :companyName")
    public Company getCompany(final @Param("companyName") String companyName);
}
