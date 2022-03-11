package co.com.sofka.retofinal.encargadoventa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.encargadoventa.values.FechaVenta;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.retofinal.vehiculo.values.VentaID;

public class AgregarVenta extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final VentaID ventaID;
    private final VehiculoID vehiculoID;
    private final ClienteID clienteID;
    private final FechaVenta fechaVenta;
    private final Monto monto;

    public AgregarVenta(EncargadoVentaID encargadoVentaID, VentaID ventaID,
                        VehiculoID vehiculoID, ClienteID clienteID, FechaVenta fechaVenta, Monto monto) {
        this.encargadoVentaID = encargadoVentaID;
        this.ventaID = ventaID;
        this.vehiculoID = vehiculoID;
        this.clienteID = clienteID;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public VentaID getVentaID() {
        return ventaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public FechaVenta getFechaVenta() {
        return fechaVenta;
    }

    public Monto getMonto() {
        return monto;
    }
}
