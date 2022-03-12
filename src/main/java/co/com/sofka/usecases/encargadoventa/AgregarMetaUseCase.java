package co.com.sofka.usecases.encargadoventa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.AgregarMeta;

public class AgregarMetaUseCase extends UseCase<RequestCommand<AgregarMeta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMeta> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.agregarMeta(
                comando.getMetaID(),
                comando.getObjetivo(),
                comando.getBonificacion()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
