package co.com.sofka.usecases.encargadoventa.localtrabajo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.localtrabajo.ActualizarNombreLocalTrabajo;

public class ActualizarNombreLocalTrabajoUseCase extends
        UseCase<RequestCommand<ActualizarNombreLocalTrabajo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreLocalTrabajo> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.actualizarNombreLocalTrabajo(
                comando.getNombre()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
