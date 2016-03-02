package com.rest.sample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * An address associated with the company.
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = -2929790075834522006L;
    @NotEmpty
    @Column(name = "lane", unique = false, nullable = false, length = 50)
    private String lane;
    @NotEmpty
    @Column(name = "city", unique = false, nullable = false, length = 50)
    private String city;
    @NotEmpty
    @Column(name = "country", unique = false, nullable = false, length = 20)
    private String country;

    /**
     * Returns the lane associated with the firm.
     * 
     * @return
     */
    public String getLane() {
        return lane;
    }

    /**
     * Associate the lane associated with the firm.
     * 
     * @param lane
     */
    public void setLane(final String lane) {
        this.lane = lane;
    }

    /**
     * Returns the city associated with the firm.
     * 
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Associate the city where this firm is located.
     * 
     * @param city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Returns the country where the firm is.
     * 
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * Associate the country where this firm is located.
     * 
     * @param country
     */
    public void setCountry(final String country) {
        this.country = country;
    }
}
