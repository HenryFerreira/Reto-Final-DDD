package co.com.sofka.retofinal.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

import java.util.List;

public class AgregarLocalAsociado extends Command {
    private final ClienteID clienteID;
    private final LocalAsociadoID localAsociadoID;
    private final Nombre nombre;
    private final List<Telefono> telefonos;

    public AgregarLocalAsociado(ClienteID clienteID, LocalAsociadoID localAsociadoID, Nombre nombre, List<Telefono> telefonos) {
        this.clienteID = clienteID;
        this.localAsociadoID = localAsociadoID;
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public ClienteID getClienteID() {
        return clienteID;
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
