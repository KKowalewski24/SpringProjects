package pl.kkowalewski.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits;

    /*------------------------ METHODS REGION ------------------------*/
    public Pet() {
    }

    public Pet(String name, PetType petType, Owner owner, LocalDate birthDate) {
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
    }

    public Pet(String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public PetType getPetType() {
        return petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pet)) return false;

        Pet pet = (Pet) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(name, pet.name)
                .append(petType, pet.petType)
                .append(owner, pet.owner)
                .append(birthDate, pet.birthDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(name)
                .append(petType)
                .append(owner)
                .append(birthDate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .append("petType", petType)
                .append("owner", owner)
                .append("birthDate", birthDate)
                .toString();
    }
}
