package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Name implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public final static long serialVersionUID = 420620315591775395L;

    private String title;
    private String first;
    private String last;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Name() {
    }

    public Name(String title, String first, String last,
                Map<String, Object> additionalProperties) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.additionalProperties = additionalProperties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
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

        Name name = (Name) o;

        return new EqualsBuilder()
                .append(title, name.title)
                .append(first, name.first)
                .append(last, name.last)
                .append(additionalProperties, name.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(title)
                .append(first)
                .append(last)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("first", first)
                .append("last", last)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
