package co.com.sofka.retofinal.cliente.commands.localasociado;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;

public class ActualizarNombreLocalAsociado extends Command {
    private final ClienteID clienteID;
    private final LocalAsociadoID localAsociadoID;
    private final Nombre nombre;

    public ActualizarNombreLocalAsociado(ClienteID clienteID, LocalAsociadoID localAsociadoID, Nombre nombre) {
        this.clienteID = clienteID;
        this.localAsociadoID = localAsociadoID;
        this.nombre = nombre;
    }

    public LocalAsociadoID getLocalAsociadoID() {
        return localAsociadoID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
