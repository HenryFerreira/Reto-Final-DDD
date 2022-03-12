package co.com.sofka.usecases.vehiculo.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.vehiculo.Vehiculo;
import co.com.sofka.retofinal.vehiculo.commands.fichatecnica.ActualizarDescripcionFichaTecnica;

public class ActualizarDescripcionFichaTecnicaUseCase extends
        UseCase<RequestCommand<ActualizarDescripcionFichaTecnica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionFichaTecnica> input) {
        var comando = input.getCommand();
        var vehiculo = Vehiculo.form(comando.getVehiculoID(), retrieveEvents());

        vehiculo.actualizarDescripcionFichaTecnica(
                comando.getDescripcion()
        );
        emit().onResponse(new ResponseEvents(vehiculo.getUncommittedChanges()));
    }
}
