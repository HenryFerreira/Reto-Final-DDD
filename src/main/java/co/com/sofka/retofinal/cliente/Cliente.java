package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
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
        appendChange(new ClienteCreado(nombre, direccion)).apply();
    }

    public void agregarCompra(CompraID compraID, VehiculoID vehiculoID,
                              EncargadoVentaID encargadoVentaID, FechaPago fechaPago, Monto monto) {
        appendChange(new CompraAgregada(compraID, vehiculoID, encargadoVentaID, fechaPago, monto)).apply();
    }

    public void agregarLocalAsociado(LocalAsociadoID localAsociadoID, Nombre nombre, List<Telefono> telefonos) {
        appendChange(new LocalAsociadoAgregado(localAsociadoID, nombre, telefonos)).apply();
    }

    public void actualizarNombre(Nombre nombre) {
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void actualizarDirccion(Direccion direccion) {
        appendChange(new DireccionActualizada(direccion)).apply();
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
}
