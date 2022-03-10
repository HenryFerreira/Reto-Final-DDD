package co.com.sofka.retofinal.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class ClienteCreado extends DomainEvent {
    private final Nombre nombre;
    private final Direccion direccion;

    public ClienteCreado(Nombre nombre, Direccion direccion) {
        super("sofka.cliente.clientecreado");
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
