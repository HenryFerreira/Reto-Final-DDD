package co.com.sofka.retofinal.cliente.events.localasociado;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

import java.util.List;

public class TelefonoAgregado extends DomainEvent {
    private final LocalAsociadoID localAsociadoID;
    private final Telefono telefono;

    public TelefonoAgregado(LocalAsociadoID localAsociadoID, Telefono telefono) {
        super("sofka.cliente.telefonoagregado");
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
