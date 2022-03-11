package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Matricula implements ValueObject<String> {
    private final String value;

    public Matricula(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La matricula no puede estar vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(value, matricula.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
