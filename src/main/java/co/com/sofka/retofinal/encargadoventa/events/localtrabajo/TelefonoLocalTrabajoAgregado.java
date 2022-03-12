package co.com.sofka.retofinal.encargadoventa.events.localtrabajo;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

public class TelefonoLocalTrabajoAgregado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoLocalTrabajoAgregado(Telefono telefono) {
        super("sofka.encargadoventa.telefonolocaltrabajoagregado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
