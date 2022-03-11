package co.com.sofka.retofinal.encargadoventa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.LocalTrabajo;
import co.com.sofka.retofinal.genericos.Nombre;

public class EncargadoVentaCreado extends DomainEvent {
    private final Nombre nombre;
    private final LocalTrabajo localTrabajo;

    public EncargadoVentaCreado(Nombre nombre, LocalTrabajo localTrabajo) {
        super("sofka.encargadoventa.encargadoventacreado");
        this.nombre = nombre;
        this.localTrabajo = localTrabajo;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public LocalTrabajo getLocalTrabajo() {
        return localTrabajo;
    }
}
