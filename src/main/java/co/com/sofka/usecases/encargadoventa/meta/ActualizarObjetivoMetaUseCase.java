package co.com.sofka.usecases.encargadoventa.meta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.meta.ActualizarObjetivoMeta;

public class ActualizarObjetivoMetaUseCase extends
        UseCase<RequestCommand<ActualizarObjetivoMeta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarObjetivoMeta> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.actualizarObjetivoMeta(
                comando.getMetaID(),
                comando.getObjetivo()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
