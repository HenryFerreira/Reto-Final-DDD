package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;

public class Garantia extends Entity<GarantiaID> {
    private final FechaEmision fechaEmision;
    private final FechaVigencia fechaVigencia;

    public Garantia(GarantiaID garantiaID, FechaEmision fechaEmision, FechaVigencia fechaVigencia) {
        super(garantiaID);
        this.fechaEmision = fechaEmision;
        this.fechaVigencia = fechaVigencia;
    }

    public FechaEmision fechaEmision() {
        return fechaEmision;
    }

    public FechaVigencia fechaVigencia() {
        return fechaVigencia;
    }
}
