package co.com.sofka.usecases.vehiculo.garantia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.vehiculo.Vehiculo;
import co.com.sofka.retofinal.vehiculo.commands.garantia.AsignarFechaVigenciaGarantia;

public class AsignarFechaVigenciaGarantiaUseCase extends
        UseCase<RequestCommand<AsignarFechaVigenciaGarantia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarFechaVigenciaGarantia> input) {
        var comando = input.getCommand();
        var vehiculo = Vehiculo.form(comando.getVehiculoID(), retrieveEvents());

        vehiculo.asignarFechaVigenciaGarantia(
                comando.getFechaVigencia()
        );
        emit().onResponse(new ResponseEvents(vehiculo.getUncommittedChanges()));
    }
}
