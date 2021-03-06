package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.encargadoventa.values.FechaVenta;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.retofinal.vehiculo.values.VentaID;

public class Venta extends Entity<VentaID> {
    private final VehiculoID vehiculoID;
    private final ClienteID clienteID;
    private final FechaVenta fechaVenta;
    private final Monto monto;

    public Venta(VentaID ventaID, VehiculoID vehiculoID, ClienteID clienteID, FechaVenta fechaVenta, Monto monto) {
        super(ventaID);
        this.vehiculoID = vehiculoID;
        this.clienteID = clienteID;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    public String detallesVenta() {
        return "Detalles de la Venta: \n" +
                "Identificador de la Venta: " + this.entityId.value() + "\n" +
                "Identificador del Vehiculo: " + this.vehiculoID.value() + "\n" +
                "Identificador del Cliente: " + this.clienteID.value() + "\n" +
                "Fecha de la Venta: " + this.fechaVenta.value() + "\n" +
                "Monto de la Venta: " + this.monto.value();
    }

    public VehiculoID vehiculoID() {
        return vehiculoID;
    }

    public ClienteID clienteID() {
        return clienteID;
    }

    public FechaVenta fechaVenta() {
        return fechaVenta;
    }

    public Monto monto() {
        return monto;
    }
}
