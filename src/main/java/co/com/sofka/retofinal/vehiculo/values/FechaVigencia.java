package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaVigencia implements ValueObject<Date> {
    private final Date value;

    public FechaVigencia(Date value) {
        this.value = Objects.requireNonNull(value);
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaVigencia that = (FechaVigencia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
