package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ExpirationDate implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public final static long serialVersionUID = 4661228813349752965L;

    private String date;
    private Integer timezoneType;
    private String timezone;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public ExpirationDate() {
    }

    public ExpirationDate(String date, Integer timezoneType, String timezone,
                          Map<String, Object> additionalProperties) {
        this.date = date;
        this.timezoneType = timezoneType;
        this.timezone = timezone;
        this.additionalProperties = additionalProperties;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(Integer timezoneType) {
        this.timezoneType = timezoneType;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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

        ExpirationDate that = (ExpirationDate) o;

        return new EqualsBuilder()
                .append(date, that.date)
                .append(timezoneType, that.timezoneType)
                .append(timezone, that.timezone)
                .append(additionalProperties, that.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(date)
                .append(timezoneType)
                .append(timezone)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("timezoneType", timezoneType)
                .append("timezone", timezone)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
