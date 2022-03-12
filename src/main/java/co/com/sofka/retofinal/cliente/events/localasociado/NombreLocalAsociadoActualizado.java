package co.com.sofka.retofinal.cliente.events.localasociado;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;

public class NombreLocalAsociadoActualizado extends DomainEvent {
    private final LocalAsociadoID localAsociadoID;
    private final Nombre nombre;

    public NombreLocalAsociadoActualizado(LocalAsociadoID localAsociadoID, Nombre nombre) {
        super("sofka.cliente.nombrelocalasociadoactualizado");
        this.localAsociadoID = localAsociadoID;
        this.nombre = nombre;
    }

    public LocalAsociadoID getLocalAsociadoID() {
        return localAsociadoID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
