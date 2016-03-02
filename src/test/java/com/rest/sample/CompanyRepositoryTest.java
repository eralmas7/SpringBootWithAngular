package com.rest.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.rest.sample.model.Address;
import com.rest.sample.model.Beneficiary;
import com.rest.sample.model.Company;
import com.rest.sample.model.Contact;
import com.rest.sample.repository.CompanyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    private Company company;

    private Address getAddress() {
        Address address = new Address();
        address.setCity("Mumbai");
        address.setCountry("India");
        address.setLane("Pipe Road");
        return address;
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setEmail("eralmas7@yahoo.com");
        contact.setPhone("+91-9594146980");
        return contact;
    }

    private Set<Beneficiary> getBeneficiaries() {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setName("bene1");
        Beneficiary anotherBeneficiary = new Beneficiary();
        anotherBeneficiary.setName("bene2");
        Set<Beneficiary> beneficiaries = new HashSet<Beneficiary>();
        beneficiaries.add(beneficiary);
        beneficiaries.add(anotherBeneficiary);
        return beneficiaries;
    }

    @Before
    public void setUp() {
        company = new Company();
        company.setName("Morgan Stanley Advantage Services Pvt. Ltd.");
        company.setAddress(getAddress());
        company.setContact(getContact());
        company.setBeneficiaries(getBeneficiaries());
        company = companyRepository.save(company);
    }

    @Test
    public void canFetchCompany() {
        Long companyId = company.getCompanyId();
        final Company company = companyRepository.findOne(companyId);
        assertEquals(company.getCompanyId(), companyId);
        assertEquals(company.getName(), this.company.getName());
        assertNotNull(company.getBeneficiaries());
    }
}
