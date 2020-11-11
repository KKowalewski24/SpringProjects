package pl.kkowalewski.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    /*------------------------ FIELDS REGION ------------------------*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Vet() {
    }

    public Vet(String firstName, String lastName, Set<Speciality> specialities) {
        super(firstName, lastName);
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public String getSpecialitiesToString() {
        StringBuilder builder = new StringBuilder();

        int iterator = 0;
        for (Speciality it : specialities) {
            if (iterator == 0) {
                builder.append(it.getDescription());
            } else {
                builder.append(", ").append(it.getDescription());
            }
            iterator++;
        }

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Vet)) {
            return false;
        }

        Vet vet = (Vet) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(specialities, vet.specialities)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(specialities)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("specialities", specialities)
                .toString();
    }
}
