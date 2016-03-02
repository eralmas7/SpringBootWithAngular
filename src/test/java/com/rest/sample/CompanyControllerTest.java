package com.rest.sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.StringWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.sample.controller.CompanyController;
import com.rest.sample.model.Company;
import com.rest.sample.service.CompanyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = {Bootstrap.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class CompanyControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private CompanyController companyController;
    @Mock
    private CompanyService companyService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    public void testGetCompanyRecord() throws Exception {
        mockMvc.perform(get("/companies/{companyId}", 1)).andExpect(status().isOk());
    }

    @Test
    public void testDeleteCompanyRecord() throws Exception {
        mockMvc.perform(delete("/companies/{companyId}", 1)).andExpect(status().isOk());
    }

    @Test
    public void testAddCompanyRecord() throws Exception {
        Mockito.when(companyService.addCompany(Mockito.any(Company.class))).thenReturn(getCompany());
        mockMvc.perform(post("/companies").content(getCompanyJson(getCompany())).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().is2xxSuccessful());
    }

    private Company getCompany() {
        final Company company = new Company();
        company.setCompanyId(1L);
        return company;
    }

    private String getCompanyJson(final Company company) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, company);
        return stringWriter.toString();
    }

    @Test
    public void testUpdateCompanyRecord() throws Exception {
        Mockito.when(companyService.updateCompany(Mockito.any(Company.class))).thenReturn(getCompany());
        mockMvc.perform(put("/companies/{companyId}", 1).content(getCompanyJson(getCompany())).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }

    @Test
    public void testGetAllCompanyRecords() throws Exception {
        mockMvc.perform(get("/companies")).andExpect(status().isOk());
    }
}
