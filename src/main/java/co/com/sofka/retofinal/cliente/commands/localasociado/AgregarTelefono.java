package co.com.sofka.retofinal.cliente.commands.localasociado;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

import java.util.List;

public class AgregarTelefono extends Command {

    private final ClienteID clienteID;
    private final LocalAsociadoID localAsociadoID;
    private final Telefono telefono;

    public AgregarTelefono(ClienteID clienteID, LocalAsociadoID localAsociadoID, Telefono telefono) {
        this.clienteID = clienteID;
        this.localAsociadoID = localAsociadoID;
        this.telefono = telefono;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public LocalAsociadoID getLocalAsociadoID() {
        return localAsociadoID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
