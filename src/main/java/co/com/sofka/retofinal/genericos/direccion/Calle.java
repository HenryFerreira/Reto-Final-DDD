package co.com.sofka.retofinal.genericos.direccion;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Calle implements ValueObject<String> {
    private final String value;

    public Calle(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La calle no puede estar vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calle calle = (Calle) o;
        return Objects.equals(value, calle.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
