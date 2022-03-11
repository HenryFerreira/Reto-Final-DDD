package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Bonificacion implements ValueObject<Double> {
    private final Double value;

    public Bonificacion(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bonificacion that = (Bonificacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
