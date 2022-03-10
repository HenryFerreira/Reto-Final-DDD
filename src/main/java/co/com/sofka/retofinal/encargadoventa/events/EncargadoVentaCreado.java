package co.com.sofka.retofinal.encargadoventa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;

public class EncargadoVentaCreado extends DomainEvent {
    private final Nombre nombre;

    public EncargadoVentaCreado(Nombre nombre) {
        super("sofka.encargadoventa.encargadoventacreado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
