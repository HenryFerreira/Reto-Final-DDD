package co.com.sofka.retofinal.vehiculo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;

public class GarantiaAsignada extends DomainEvent {
    private final GarantiaID garantiaID;
    private final FechaEmision fechaEmision;
    private final FechaVigencia fechaVigencia;

    public GarantiaAsignada(GarantiaID garantiaID, FechaEmision fechaEmision, FechaVigencia fechaVigencia) {
        super("sofka.vehiculo.garantiaasignada");
        this.garantiaID = garantiaID;
        this.fechaEmision = fechaEmision;
        this.fechaVigencia = fechaVigencia;
    }
}
