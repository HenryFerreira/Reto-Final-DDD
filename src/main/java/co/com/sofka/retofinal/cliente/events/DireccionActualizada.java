package co.com.sofka.retofinal.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class DireccionActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionActualizada(Direccion direccion) {
        super("sofka.cliente.DireccionActualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
