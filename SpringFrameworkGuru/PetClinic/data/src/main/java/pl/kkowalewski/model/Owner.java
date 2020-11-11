package pl.kkowalewski.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {

    /*------------------------ FIELDS REGION ------------------------*/
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Owner(String firstName, String lastName, String address, String city,
                 String telephoneNumber) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephoneNumber = telephoneNumber;
    }

    public Owner(String firstName, String lastName, String address, String city,
                 String telephoneNumber, Set<Pet> pets) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephoneNumber = telephoneNumber;
        this.pets = pets;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Owner owner = (Owner) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(address, owner.address)
                .append(city, owner.city)
                .append(telephoneNumber, owner.telephoneNumber)
                .append(pets, owner.pets)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(address)
                .append(city)
                .append(telephoneNumber)
                .append(pets)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("address", address)
                .append("city", city)
                .append("telephoneNumber", telephoneNumber)
                .append("pets", pets)
                .toString();
    }
}
