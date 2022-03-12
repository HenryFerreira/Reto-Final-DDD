package co.com.sofka.retofinal.vehiculo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class AsignarGarantia extends Command {
    private final VehiculoID vehiculoID;
    private final GarantiaID garantiaID;
    private final FechaEmision fechaEmision;
    private final FechaVigencia fechaVigencia;

    public AsignarGarantia(VehiculoID vehiculoID, GarantiaID garantiaID, FechaEmision fechaEmision, FechaVigencia fechaVigencia) {
        this.vehiculoID = vehiculoID;
        this.garantiaID = garantiaID;
        this.fechaEmision = fechaEmision;
        this.fechaVigencia = fechaVigencia;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public GarantiaID getGarantiaID() {
        return garantiaID;
    }

    public FechaEmision getFechaEmision() {
        return fechaEmision;
    }

    public FechaVigencia getFechaVigencia() {
        return fechaVigencia;
    }
}
