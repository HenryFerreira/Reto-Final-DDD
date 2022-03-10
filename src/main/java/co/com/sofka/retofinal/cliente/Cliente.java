package co.com.sofka.retofinal.cliente;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class Cliente extends AggregateEvent<ClienteID>{
    public Cliente(ClienteID clienteID, Nombre nombre, Direccion direccion) {
        super(clienteID);
    }
}
