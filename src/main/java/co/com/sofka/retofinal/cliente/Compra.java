package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class Compra extends Entity<CompraID> {
    private final CompraID compraID;
    private final VehiculoID vehiculoID;
    private final EncargadoVentaID encargadoVentaID;
    private final FechaPago fechaPago;
    private final Monto monto;

    public Compra(CompraID compraID, VehiculoID vehiculoID,
                  EncargadoVentaID encargadoVentaID, FechaPago fechaPago, Monto monto) {
        super(compraID);
        this.compraID = compraID;
        this.vehiculoID = vehiculoID;
        this.encargadoVentaID = encargadoVentaID;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }

    public CompraID compraID() {
        return compraID;
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
