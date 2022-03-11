package co.com.sofka.retofinal.genericos;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<Integer> {
    private final Integer value;

    public Telefono(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(value, telefono.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
