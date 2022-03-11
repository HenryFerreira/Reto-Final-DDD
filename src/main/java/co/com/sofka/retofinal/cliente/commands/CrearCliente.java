package co.com.sofka.retofinal.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class CrearCliente extends Command {
    private final ClienteID clienteID;
    private final Nombre nombre;
    private final Direccion direccion;

    public CrearCliente(ClienteID clienteID, Nombre nombre, Direccion direccion) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
