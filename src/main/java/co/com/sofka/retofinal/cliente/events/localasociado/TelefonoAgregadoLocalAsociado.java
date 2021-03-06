package co.com.sofka.retofinal.cliente.events.localasociado;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Telefono;

public class TelefonoAgregadoLocalAsociado extends DomainEvent {
    private final LocalAsociadoID localAsociadoID;
    private final Telefono telefono;

    public TelefonoAgregadoLocalAsociado(LocalAsociadoID localAsociadoID, Telefono telefono) {
        super("sofka.cliente.telefonoagregadoLocalasociado");
        this.localAsociadoID = localAsociadoID;
        this.telefono = telefono;
    }

    public LocalAsociadoID getLocalAsociadoID() {
        return localAsociadoID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
