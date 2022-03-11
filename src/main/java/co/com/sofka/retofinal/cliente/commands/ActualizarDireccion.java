package co.com.sofka.retofinal.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class ActualizarDireccion extends Command {
    private final ClienteID clienteID;
    private final Direccion direccion;

    public ActualizarDireccion(ClienteID clienteID, Direccion direccion) {
        this.clienteID = clienteID;
        this.direccion = direccion;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
