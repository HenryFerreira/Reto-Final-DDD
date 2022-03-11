package co.com.sofka.retofinal.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class AgregarCompra extends Command {
    private final ClienteID clienteID;
    private final CompraID compraID;
    private final VehiculoID vehiculoID;
    private final EncargadoVentaID encargadoVentaID;
    private final FechaPago fechaPago;
    private final Monto monto;

    public AgregarCompra(ClienteID clienteID, CompraID compraID, VehiculoID vehiculoID,
                         EncargadoVentaID encargadoVentaID, FechaPago fechaPago, Monto monto) {
        this.clienteID = clienteID;
        this.compraID = compraID;
        this.vehiculoID = vehiculoID;
        this.encargadoVentaID = encargadoVentaID;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public CompraID getCompraID() {
        return compraID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public FechaPago getFechaPago() {
        return fechaPago;
    }

    public Monto getMonto() {
        return monto;
    }
}
