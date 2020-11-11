package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Location implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public final static long serialVersionUID = -3532048267747973846L;

    private String street;
    private String city;
    private String state;
    private String postcode;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Location() {
    }

    public Location(String street, String city, String state, String postcode,
                    Map<String, Object> additionalProperties) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.additionalProperties = additionalProperties;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Location location = (Location) o;

        return new EqualsBuilder()
                .append(street, location.street)
                .append(city, location.city)
                .append(state, location.state)
                .append(postcode, location.postcode)
                .append(additionalProperties, location.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(street)
                .append(city)
                .append(state)
                .append(postcode)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("street", street)
                .append("city", city)
                .append("state", state)
                .append("postcode", postcode)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
