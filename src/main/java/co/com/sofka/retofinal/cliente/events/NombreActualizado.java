package co.com.sofka.retofinal.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;

import java.util.List;

public class NombreActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("sofka.cliente.nombreactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
