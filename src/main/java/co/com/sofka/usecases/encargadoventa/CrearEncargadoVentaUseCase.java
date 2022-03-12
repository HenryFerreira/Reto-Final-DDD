package co.com.sofka.usecases.encargadoventa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.CrearEncargadoVenta;

public class CrearEncargadoVentaUseCase extends UseCase<RequestCommand<CrearEncargadoVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEncargadoVenta> input) {
        CrearEncargadoVenta crearEncargadoVenta = input.getCommand();

        EncargadoVenta encargadoVenta = new EncargadoVenta(
                crearEncargadoVenta.getEncargadoVentaID(),
                crearEncargadoVenta.getNombre(),
                crearEncargadoVenta.getLocalTrabajo()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
