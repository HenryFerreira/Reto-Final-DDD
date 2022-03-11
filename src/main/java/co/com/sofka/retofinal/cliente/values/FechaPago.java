package co.com.sofka.retofinal.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaPago implements ValueObject<Date> {
    private final Date value;

    public FechaPago(Date value) {
        this.value = Objects.requireNonNull(value);
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaPago fechaPago = (FechaPago) o;
        return Objects.equals(value, fechaPago.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
