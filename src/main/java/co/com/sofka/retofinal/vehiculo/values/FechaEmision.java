package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaEmision implements ValueObject<Date> {
    private final Date value;

    public FechaEmision(Date value) {
        this.value = Objects.requireNonNull(value);
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaEmision that = (FechaEmision) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
