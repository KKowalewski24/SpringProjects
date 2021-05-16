package pl.kkowalewski.showroom.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Showroom extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    private String name;
    private String city;
    @JsonManagedReference
    @OneToMany(mappedBy = "showroom")
    private List<Car> cars;

    /*------------------------ METHODS REGION ------------------------*/
    public Showroom() {
    }

    public Showroom(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Showroom(String name, String city, List<Car> cars) {
        this.name = name;
        this.city = city;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("name", name)
                .append("city", city)
                .append("cars", cars)
                .toString();
    }
}
