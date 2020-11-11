package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Job implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public final static long serialVersionUID = -4985150429002262656L;

    private String title;
    private String company;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Job() {
    }

    public Job(String title, String company, Map<String, Object> additionalProperties) {
        this.title = title;
        this.company = company;
        this.additionalProperties = additionalProperties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

        Job job = (Job) o;

        return new EqualsBuilder()
                .append(title, job.title)
                .append(company, job.company)
                .append(additionalProperties, job.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(title)
                .append(company)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("company", company)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
