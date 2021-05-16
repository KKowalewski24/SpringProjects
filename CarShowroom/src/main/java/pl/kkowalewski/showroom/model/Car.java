package pl.kkowalewski.showroom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.kkowalewski.showroom.model.type.BrandType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Car extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    private BrandType brandType;
    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;
    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Showroom showroom;

    /*------------------------ METHODS REGION ------------------------*/
    public Car() {
    }

    public Car(BrandType brandType, Engine engine) {
        this.brandType = brandType;
        this.engine = engine;
    }

    public Car(BrandType brandType, Engine engine, Showroom showroom) {
        this.brandType = brandType;
        this.engine = engine;
        this.showroom = showroom;
    }

    public BrandType getBrandType() {
        return brandType;
    }

    public Engine getEngine() {
        return engine;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setBrandType(BrandType brandType) {
        this.brandType = brandType;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("brandType", brandType)
                .append("engine", engine)
                .append("showroom", showroom)
                .toString();
    }
}
