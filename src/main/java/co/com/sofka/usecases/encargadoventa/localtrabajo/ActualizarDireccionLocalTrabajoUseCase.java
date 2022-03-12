package co.com.sofka.usecases.encargadoventa.localtrabajo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.localtrabajo.ActualizarDireccionLocalTrabajo;

public class ActualizarDireccionLocalTrabajoUseCase extends
        UseCase<RequestCommand<ActualizarDireccionLocalTrabajo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDireccionLocalTrabajo> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.actualizarDireccionLocalTrabajo(
                comando.getDireccion()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
