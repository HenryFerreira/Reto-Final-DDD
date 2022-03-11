package co.com.sofka.retofinal.genericos.direccion;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NroPuerta implements ValueObject<String> {
    private final String value;

    public NroPuerta(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La numero de la puerta no puede estar vacio");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NroPuerta nroPuerta = (NroPuerta) o;
        return Objects.equals(value, nroPuerta.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
