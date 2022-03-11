package co.com.sofka.retofinal.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

import java.util.List;

public class LocalAsociadoAgregado extends DomainEvent {
    private final LocalAsociadoID localAsociadoID;
    private final Nombre nombre;
    private final List<Telefono> telefonos;

    public LocalAsociadoAgregado(LocalAsociadoID localAsociadoID, Nombre nombre, List<Telefono> telefonos) {
        super("sofka.cliente.localasociadoagregado");

        this.localAsociadoID = localAsociadoID;
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public LocalAsociadoID getLocalAsociadoID() {
        return localAsociadoID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }
}
