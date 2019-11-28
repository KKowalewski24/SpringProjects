package pl.kkowalewski.forminput.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class PersonForm {

    /*------------------------ FIELDS REGION ------------------------*/
    @NonNull
    @Size(min = 2, max = 30)
    private String name;

    @NonNull
    @Min(18)
    private Integer age;

    /*------------------------ METHODS REGION ------------------------*/
    public PersonForm(@Size(min = 2, max = 30) String name, @Min(18) Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonForm that = (PersonForm) o;

        return new EqualsBuilder()
                .append(name, that.name)
                .append(age, that.age)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(age)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
