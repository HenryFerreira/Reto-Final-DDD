package co.com.sofka.retofinal.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Monto implements ValueObject<Double> {
    private final Double value;

    public Monto(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monto monto = (Monto) o;
        return Objects.equals(value, monto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
