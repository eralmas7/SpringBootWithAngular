package com.rest.sample.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Company entity that would be serialised into storage media.
 */
@Entity
@Table(name = "COMPANY", uniqueConstraints = {@UniqueConstraint(columnNames = "company_id"), @UniqueConstraint(columnNames = "company_name")})
public class Company implements Serializable {

    private static final long serialVersionUID = -2251792706876207652L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", unique = true, nullable = false)
    private Long companyId;// unique company id that might not be generated later.
    @NotEmpty
    @Column(name = "company_name", unique = true, nullable = false, length = 100)
    private String name;
    @Embedded
    @NotNull
    private Address address;
    @Embedded
    private Contact contact;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Beneficiary> beneficiaries;

    /**
     * Returns the id associated with this company.
     * 
     * @return
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * Associated id with the company.
     * 
     * @param companyId
     */
    public void setCompanyId(final Long companyId) {
        this.companyId = companyId;
    }

    /**
     * Returns name associated with this company.
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the company.
     * 
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the address associated with this firm.
     * 
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param address
     */
    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * Returns the contact details associated with the firm.
     * 
     * @return
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Returns the contact details of the firm.
     * 
     * @param contact
     */
    public void setContact(final Contact contact) {
        this.contact = contact;
    }

    /**
     * Returns the beneficiaries associated with the firm.
     * 
     * @return
     */
    public Set<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    /**
     * Associated beneficiaries with the firm.
     * 
     * @param beneficiaries
     */
    public void setBeneficiaries(final Set<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }
}
