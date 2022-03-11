package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Objetivo implements ValueObject<String> {
    private final String value;

    public Objetivo(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("El objetivo no puede estar vacio");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objetivo objetivo = (Objetivo) o;
        return Objects.equals(value, objetivo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
