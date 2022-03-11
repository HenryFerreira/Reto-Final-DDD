package co.com.sofka.retofinal.encargadoventa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.encargadoventa.values.FechaVenta;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.retofinal.vehiculo.values.VentaID;

public class VentaAgregada extends DomainEvent {
    private final VentaID ventaID;
    private final VehiculoID vehiculoID;
    private final ClienteID clienteID;
    private final FechaVenta fechaVenta;
    private final Monto monto;

    public VentaAgregada(VentaID ventaID, VehiculoID vehiculoID, ClienteID clienteID,
                         FechaVenta fechaVenta, Monto monto) {
        super("sofka.encargadoventa.ventaagregada");
        this.ventaID = ventaID;
        this.vehiculoID = vehiculoID;
        this.clienteID = clienteID;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }
}
