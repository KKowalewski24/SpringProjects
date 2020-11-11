package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final Long serialVersionUID = 270727596527329664L;

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String phone;
    private Job job;
    private Billing billing;
    private String language;
    private String currency;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public User() {
    }

    public User(String gender, Name name, Location location, String email, Login login,
                String phone, Job job, Billing billing, String language, String currency,
                Map<String, Object> additionalProperties) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.phone = phone;
        this.job = job;
        this.billing = billing;
        this.language = language;
        this.currency = currency;
        this.additionalProperties = additionalProperties;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

        User user = (User) o;

        return new EqualsBuilder()
                .append(gender, user.gender)
                .append(name, user.name)
                .append(location, user.location)
                .append(email, user.email)
                .append(login, user.login)
                .append(phone, user.phone)
                .append(job, user.job)
                .append(billing, user.billing)
                .append(language, user.language)
                .append(currency, user.currency)
                .append(additionalProperties, user.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(gender)
                .append(name)
                .append(location)
                .append(email)
                .append(login)
                .append(phone)
                .append(job)
                .append(billing)
                .append(language)
                .append(currency)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("gender", gender)
                .append("name", name)
                .append("location", location)
                .append("email", email)
                .append("login", login)
                .append("phone", phone)
                .append("job", job)
                .append("billing", billing)
                .append("language", language)
                .append("currency", currency)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
