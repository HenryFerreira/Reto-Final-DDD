package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.retofinal.vehiculo.events.GarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;

public class VehiculoChange extends EventChange {
    public VehiculoChange(Vehiculo vehiculo) {
        apply((VehiculoCreado evento) -> {
            vehiculo.matriculacion = evento.getMatriculacion();
            vehiculo.fichaTecnica = evento.getFichaTecnica();
            vehiculo.garantia = null;
        });

        apply((GarantiaAsignada evento) -> {
            vehiculo.garantia = new Garantia(
                    evento.getGarantiaID(),
                    evento.getFechaEmision(),
                    evento.getFechaVigencia()
            );
        });
    }
}
