package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

import java.util.List;
import java.util.Objects;

public class Cliente extends AggregateEvent<ClienteID> {
    protected List<Compra> compras;
    protected List<LocalAsociado> localesAsociados;
    protected Nombre nombre;
    protected Direccion direccion;

    public Cliente(ClienteID clienteID, Nombre nombre, Direccion direccion) {
        super(clienteID);
        appendChange(new ClienteCreado(nombre, direccion)).apply();
    }

    public void agregarCompra(Compra compra) {
        this.compras.add(Objects.requireNonNull(compra));
    }

    public void agregarLocalAsociado(LocalAsociado localAsociado) {
        this.localesAsociados.add(Objects.requireNonNull(localAsociado));
    }

    public void listarCompras() {
        System.out.println("Lista de Compras: \n");
        for (Compra elemento : this.compras) {
            System.out.println(elemento.detallesCompra());
        }
    }

    public void listarLocalesAsociados() {
        System.out.println("Lista de Locales Asociados: \n");
        for (LocalAsociado elemento : this.localesAsociados) {
            System.out.println(elemento.nombre().value());
        }
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarDirccion(Direccion direccion) {
        this.direccion = Objects.requireNonNull(direccion);
    }

}
