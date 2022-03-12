package co.com.sofka.retofinal.vehiculo.commands.garantia;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class AsignarFechaVigenciaGarantia extends Command {
    private final VehiculoID vehiculoID;
    private final FechaVigencia fechaVigencia;

    public AsignarFechaVigenciaGarantia(VehiculoID vehiculoID, FechaVigencia fechaVigencia) {
        this.vehiculoID = vehiculoID;
        this.fechaVigencia = fechaVigencia;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public FechaVigencia getFechaVigencia() {
        return fechaVigencia;
    }
}
