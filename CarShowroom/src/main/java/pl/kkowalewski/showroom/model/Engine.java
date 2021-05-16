package pl.kkowalewski.showroom.model;

import pl.kkowalewski.showroom.model.type.EngineType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;

@Entity
public class Engine extends BaseEntity {

    /*------------------------ FIELDS REGION ------------------------*/
    private EngineType engineType;
    private float displacement;

    /*------------------------ METHODS REGION ------------------------*/
    public Engine() {
    }

    public Engine(EngineType engineType, float displacement) {
        this.engineType = engineType;
        this.displacement = displacement;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public float getDisplacement() {
        return displacement;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void setDisplacement(float displacement) {
        this.displacement = displacement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Engine engine = (Engine) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(displacement, engine.displacement)
                .append(engineType, engine.engineType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(engineType)
                .append(displacement)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("engineType", engineType)
                .append("displacement", displacement)
                .toString();
    }
}
