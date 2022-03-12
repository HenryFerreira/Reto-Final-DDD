package co.com.sofka.usecases.encargadoventa.meta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.meta.ActualizarBonificacionMeta;

public class ActualizarBonificacionMetaUseCase extends
        UseCase<RequestCommand<ActualizarBonificacionMeta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarBonificacionMeta> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.actualizarBonificacionMeta(
                comando.getMetaID(),
                comando.getBonificacion()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
