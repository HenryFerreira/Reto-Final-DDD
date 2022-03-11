package co.com.sofka.retofinal.genericos.direccion;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {
    private final String value;
    private final Calle calle;
    private final Ciudad ciudad;
    private final NroPuerta nroPuerta;

    public Direccion(Calle calle, Ciudad ciudad, NroPuerta nroPuerta) {
        this.calle = Objects.requireNonNull(calle);
        this.ciudad = Objects.requireNonNull(ciudad);
        this.nroPuerta = Objects.requireNonNull(nroPuerta);
        if (this.calle.value().isBlank()) {
            throw new IllegalArgumentException("La calle no puede estar vacia");
        }
        if (this.ciudad.value().isBlank()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacia");
        }
        if (this.nroPuerta.value().isBlank()) {
            throw new IllegalArgumentException("El numero de puerta no puede estar vacio");
        }

        this.value = "Ciudad: " + this.ciudad + "\n" +
                "Calle: " + this.ciudad + "\n" +
                "Numero de puerta: " + this.nroPuerta;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return Objects.equals(value, direccion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
