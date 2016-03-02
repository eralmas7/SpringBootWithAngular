package com.rest.sample.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.rest.sample.model.Address;
import com.rest.sample.model.Company;
import com.rest.sample.model.Contact;
import com.rest.sample.service.CompanyService;

@Steps
public class CompanyAdditionSteps {

    @Autowired
    private CompanyService companyService;
    private Company company;

    @Given("a user desires to add a new company record")
    public void getNewCompany() {
        company = new Company();
        final Contact contact = new Contact();
        final Address address = new Address();
        company.setContact(contact);
        company.setAddress(address);
    }

    @When("client tries to add company in $city, $country on $lane with name as $companyName and email $email")
    public void registerDetails(final String city, final String country, final String lane, final String companyName, final String email) {
        company.getContact().setEmail(email);
        company.getAddress().setCity(city);
        company.getAddress().setLane(lane);
        company.getAddress().setCountry(country);
        company.setName(companyName);
    }

    @Then("user should be allowed to add the company named $companyName")
    public void userExists(final String companyName) {
        final Company companyAdded = companyService.addCompany(company);
        Assert.assertTrue(companyAdded.getCompanyId() != null);
        Assert.assertEquals(companyAdded.getName(), companyName);
    }
}
