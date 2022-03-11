package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.events.*;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
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
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(direccion);
        appendChange(new ClienteCreado(nombre, direccion)).apply();
    }

    private Cliente(ClienteID clienteID) {
        super(clienteID);
        subscribe(new ClienteChange(this));
    }

    public static Cliente form(ClienteID clienteID, List<DomainEvent> eventos) {
        var cliente = new Cliente(clienteID);
        eventos.forEach(cliente::applyEvent);
        return cliente;
    }

    public void agregarCompra(CompraID compraID, VehiculoID vehiculoID,
                              EncargadoVentaID encargadoVentaID, FechaPago fechaPago, Monto monto) {
        Objects.requireNonNull(compraID);
        Objects.requireNonNull(vehiculoID);
        Objects.requireNonNull(encargadoVentaID);
        Objects.requireNonNull(fechaPago);
        Objects.requireNonNull(monto);
        appendChange(new CompraAgregada(compraID, vehiculoID, encargadoVentaID, fechaPago, monto)).apply();
    }

    public void agregarLocalAsociado(LocalAsociadoID localAsociadoID, Nombre nombre, List<Telefono> telefonos) {
        Objects.requireNonNull(localAsociadoID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefonos);
        appendChange(new LocalAsociadoAgregado(localAsociadoID, nombre, telefonos)).apply();
    }

    public void actualizarNombre(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void actualizarDirccion(Direccion direccion) {
        Objects.requireNonNull(direccion);
        appendChange(new DireccionActualizada(direccion)).apply();
    }

    protected void listarCompras() {
        System.out.println("Lista de Compras: \n");
        for (Compra elemento : this.compras) {
            System.out.println(elemento.detallesCompra());
        }
    }

    protected void listarLocalesAsociados() {
        System.out.println("Lista de Locales Asociados: \n");
        for (LocalAsociado elemento : this.localesAsociados) {
            System.out.println(elemento.nombre().value());
        }
    }

    public List<Compra> compras() {
        return compras;
    }

    public List<LocalAsociado> localesAsociados() {
        return localesAsociados;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }
}
