package com.rest.sample.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.rest.sample.model.Address;
import com.rest.sample.model.Company;
import com.rest.sample.service.CompanyService;

@Steps
public class CompanyDataGetterSteps {

    @Autowired
    private CompanyService companyService;
    private Company company;

    @Given("a user desires to get a company record for $companyName")
    public void getNewCompany(final String companyName) {
        company = new Company();
        company.setName(companyName);
        final Address address = new Address();
        address.setCity("Mumbai");
        address.setCountry("India");
        address.setLane("Albert's Street");
        company.setAddress(address);
    }

    @When("client tries to get a record of firm with name as XYZ corporation")
    public void registerDetails() {
        this.company = companyService.addCompany(company);
    }

    @Then("user should get the company record for $companyName")
    public void userExists(final String companyName) {
        final Company companyDetails = companyService.getCompany(this.company.getCompanyId());
        Assert.assertEquals(companyName, companyDetails.getName());
    }
}
