package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteID> {
    protected List<Compra> compras;
    protected List<LocalAsociado> localesAsociados;
    protected Nombre nombre;
    protected Direccion direccion;

    public Cliente(ClienteID clienteID, Nombre nombre, Direccion direccion) {
        super(clienteID);
        appendChange(new ClienteCreado(nombre, direccion)).apply();
    }
}
