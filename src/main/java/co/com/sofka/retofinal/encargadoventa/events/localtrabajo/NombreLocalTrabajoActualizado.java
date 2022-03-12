package co.com.sofka.retofinal.encargadoventa.events.localtrabajo;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class NombreLocalTrabajoActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreLocalTrabajoActualizado(Nombre nombre) {
        super("sofka.encargadoventa.nombrelocaltrabajoactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
