package co.com.sofka.usecases.encargadoventa;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.encargadoventa.EncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.commands.AgregarVenta;

public class AgregarVentaUseCase extends UseCase<RequestCommand<AgregarVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVenta> input) {
        var comando = input.getCommand();
        var encargadoVenta = EncargadoVenta.form(comando.getEncargadoVentaID(), retrieveEvents());

        encargadoVenta.agregarVenta(
                comando.getVentaID(),
                comando.getVehiculoID(),
                comando.getClienteID(),
                comando.getFechaVenta(),
                comando.getMonto()
        );
        emit().onResponse(new ResponseEvents(encargadoVenta.getUncommittedChanges()));
    }
}
