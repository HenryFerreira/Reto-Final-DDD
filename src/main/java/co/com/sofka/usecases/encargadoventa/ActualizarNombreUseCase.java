package co.com.sofka.usecases.encargadoventa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.ActualizarNombre;

public class ActualizarNombreUseCase extends UseCase<RequestCommand<ActualizarNombre>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombre> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.actualizarNombre(
                comando.getNombre()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
