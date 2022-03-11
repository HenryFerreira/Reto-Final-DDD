package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaVenta implements ValueObject<Date> {
    private final Date value;

    public FechaVenta(Date value) {
        this.value = Objects.requireNonNull(value);
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaVenta that = (FechaVenta) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
