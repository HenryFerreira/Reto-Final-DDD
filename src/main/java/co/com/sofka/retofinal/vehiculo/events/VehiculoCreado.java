package co.com.sofka.retofinal.vehiculo.events;

import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoCreado extends DomainEvent {
    public VehiculoCreado() {
        super("sofka.vehiculo.vehiculocreado");
    }
}
