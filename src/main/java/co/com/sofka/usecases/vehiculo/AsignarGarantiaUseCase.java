package co.com.sofka.usecases.vehiculo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.vehiculo.Vehiculo;
import co.com.sofka.retofinal.vehiculo.commands.AsignarGarantia;

public class AsignarGarantiaUseCase extends UseCase<RequestCommand<AsignarGarantia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarGarantia> input) {
        var comando = input.getCommand();
        var vehiculo = Vehiculo.form(comando.getVehiculoID(), retrieveEvents());

        vehiculo.asignarGarantia(
                comando.getGarantiaID(),
                comando.getFechaEmision(),
                comando.getFechaVigencia()
        );
        emit().onResponse(new ResponseEvents(vehiculo.getUncommittedChanges()));
    }
}
