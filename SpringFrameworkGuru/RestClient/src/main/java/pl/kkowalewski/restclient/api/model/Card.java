package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Card implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public final static long serialVersionUID = 6203456183354582742L;

    private String type;
    private String number;
    private ExpirationDate expirationDate;
    private String iban;
    private String swift;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Card() {
    }

    public Card(String type, String number, ExpirationDate expirationDate, String iban,
                String swift, Map<String, Object> additionalProperties) {
        this.type = type;
        this.number = number;
        this.expirationDate = expirationDate;
        this.iban = iban;
        this.swift = swift;
        this.additionalProperties = additionalProperties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
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

        Card card = (Card) o;

        return new EqualsBuilder()
                .append(type, card.type)
                .append(number, card.number)
                .append(expirationDate, card.expirationDate)
                .append(iban, card.iban)
                .append(swift, card.swift)
                .append(additionalProperties, card.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(number)
                .append(expirationDate)
                .append(iban)
                .append(swift)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("number", number)
                .append("expirationDate", expirationDate)
                .append("iban", iban)
                .append("swift", swift)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
