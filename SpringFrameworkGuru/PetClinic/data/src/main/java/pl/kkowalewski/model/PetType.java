package pl.kkowalewski.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    @Column(name = "type")
    private String type;

    /*------------------------ METHODS REGION ------------------------*/
    public PetType() {
    }

    public PetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof PetType)) {
            return false;
        }

        PetType petType = (PetType) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(type, petType.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(type)
                .toHashCode();
    }

    @Override
    public String toString() {
        return this.type;
    }
}
