package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class Compra extends Entity<CompraID> {
    private final VehiculoID vehiculoID;
    private final EncargadoVentaID encargadoVentaID;
    private final FechaPago fechaPago;
    private final Monto monto;

    public Compra(CompraID compraID, VehiculoID vehiculoID,
                  EncargadoVentaID encargadoVentaID, FechaPago fechaPago, Monto monto) {
        super(compraID);
        this.vehiculoID = vehiculoID;
        this.encargadoVentaID = encargadoVentaID;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }

    public String detallesCompra() {
        return "Detalles de la compra:\n" +
                "Identificador de la Compra: " + this.entityId.value() + "\n" +
                "Identificador del Vehiculo: " + this.vehiculoID.value() + "\n" +
                "Identificador del Encargado de la Venta: " + this.encargadoVentaID.value() + "\n" +
                "Fecha del Pago: " + this.fechaPago.value() + "\n" +
                "Monto de la compra: " + this.monto.value();
    }

    public VehiculoID vehiculoID() {
        return vehiculoID;
    }

    public EncargadoVentaID encargadoVentaID() {
        return encargadoVentaID;
    }

    public FechaPago fechaPago() {
        return fechaPago;
    }

    public Monto monto() {
        return monto;
    }
}
