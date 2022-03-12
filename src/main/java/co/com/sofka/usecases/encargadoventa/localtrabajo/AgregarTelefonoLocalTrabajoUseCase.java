package co.com.sofka.usecases.encargadoventa.localtrabajo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.localtrabajo.AgregarTelefonoLocalTrabajo;

public class AgregarTelefonoLocalTrabajoUseCase extends
        UseCase<RequestCommand<AgregarTelefonoLocalTrabajo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTelefonoLocalTrabajo> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.agregarTelefonoLocalTrabajo(
                comando.getTelefono()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
