package co.com.sofka.retofinal.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class CompraAgregada extends DomainEvent {
    private final CompraID compraID;
    private final VehiculoID vehiculoID;
    private final EncargadoVentaID encargadoVentaID;
    private final FechaPago fechaPago;
    private final Monto monto;

    public CompraAgregada(CompraID compraID, VehiculoID vehiculoID,
                          EncargadoVentaID encargadoVentaID, FechaPago fechaPago, Monto monto) {
        super("sofka.cliente.compraagregada");
        this.compraID = compraID;
        this.vehiculoID = vehiculoID;
        this.encargadoVentaID = encargadoVentaID;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }
}
