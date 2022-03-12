package co.com.sofka.usecases.vehiculo.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.vehiculo.Vehiculo;
import co.com.sofka.retofinal.vehiculo.commands.fichatecnica.ActualizarNombreFichaTecnica;

public class ActualizarNombreFichaTecnicaUseCase extends
        UseCase<RequestCommand<ActualizarNombreFichaTecnica>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreFichaTecnica> input) {
        var comando = input.getCommand();
        var vehiculo = Vehiculo.form(comando.getVehiculoID(), retrieveEvents());

        vehiculo.actualizarNombreFichaTecnica(
                comando.getNombre()
        );
        emit().onResponse(new ResponseEvents(vehiculo.getUncommittedChanges()));
    }
}
