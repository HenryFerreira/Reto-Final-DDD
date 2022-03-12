package co.com.sofka.retofinal.vehiculo.events.garantia;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class FechaVigenciaGarantiaAsignada extends DomainEvent {

    private final FechaVigencia fechaVigencia;

    public FechaVigenciaGarantiaAsignada(FechaVigencia fechaVigencia) {
        super("sofka.vehiculo.fechavigenciagarantiaasignada");
        this.fechaVigencia = fechaVigencia;
    }

    public FechaVigencia getFechaVigencia() {
        return fechaVigencia;
    }
}
