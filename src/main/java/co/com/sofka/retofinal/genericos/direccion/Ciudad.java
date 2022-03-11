package co.com.sofka.retofinal.genericos.direccion;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ciudad implements ValueObject<String> {
    private final String value;

    public Ciudad(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(value, ciudad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
