package co.com.sofka.retofinal.encargadoventa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("sofka.encargadoventa.nombreactualizado");
        this.nombre = nombre;
    }
}
