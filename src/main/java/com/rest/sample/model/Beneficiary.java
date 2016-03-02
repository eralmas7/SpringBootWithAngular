package com.rest.sample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Beneficiary associated with the firm.
 */
@Entity
@Table(name = "BENEFICIARY", uniqueConstraints = {@UniqueConstraint(columnNames = "id"), @UniqueConstraint(columnNames = "name")})
public class Beneficiary implements Serializable {

    private static final long serialVersionUID = -1285086248658987946L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @NotEmpty
    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(referencedColumnName = "company_id")
    private Company company;

    /**
     * Id associated with the beneficiary.
     * 
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Associated id with the beneficiary.
     * 
     * @param id
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Returns the name of the beneficiary.
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Associates the name with the beneficiary.
     * 
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the company that's associated with this beneficiary.
     * 
     * @return
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Associate Company with this beneficiary.
     * 
     * @param company
     */
    public void setCompany(final Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Beneficiary other = (Beneficiary) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
