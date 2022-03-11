package co.com.sofka.retofinal.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.Nombre;

public class ActualizarNombre extends Command {
    private final ClienteID clienteID;
    private final Nombre nombre;

    public ActualizarNombre(ClienteID clienteID, Nombre nombre) {
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
