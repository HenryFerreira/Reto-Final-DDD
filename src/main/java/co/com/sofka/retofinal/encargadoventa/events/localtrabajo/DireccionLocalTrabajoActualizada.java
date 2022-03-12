package co.com.sofka.retofinal.encargadoventa.events.localtrabajo;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class DireccionLocalTrabajoActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionLocalTrabajoActualizada( Direccion direccion) {
        super("sofka.encargadoventa.direccionlocaltrabajoactualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
