package com.rest.sample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representation of Company contact details.
 */
@Embeddable
public class Contact implements Serializable {

    private static final long serialVersionUID = 1650751335930358300L;
    @Column(name = "email", unique = false, nullable = true, length = 50)
    private String email;
    @Column(name = "phone", unique = false, nullable = true, length = 15)
    private String phone;

    /**
     * Returns email associated with the firm.
     * 
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the firm.
     * 
     * @param email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Returns the phone associated with the Company.
     * 
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Associated phone with the firm.
     * 
     * @param phone
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }
}
