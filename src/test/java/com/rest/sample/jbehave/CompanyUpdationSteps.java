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
public class CompanyUpdationSteps {

    @Autowired
    private CompanyService companyService;
    private Company company;

    @Given("a user desires to update a company record with name $companyName")
    public void getNewCompany(final String companyName) {
        company = new Company();
        company.setName(companyName);
        final Address address = new Address();
        address.setCity("Mumbai");
        address.setCountry("India");
        address.setLane("Albert's Street");
        company.setAddress(address);
    }

    @When("client tries to update company's country from India to $country for $companyName")
    public void registerDetails(final String country, final String companyName) {
        companyService.addCompany(company);
        company.getAddress().setCountry(country);
    }

    @Then("user should be successfully update the company's country to $country")
    public void userExists(final String country) {
        final Company companyUpdated = companyService.updateCompany(company);
        Assert.assertEquals(country, companyUpdated.getAddress().getCountry());
    }
}
