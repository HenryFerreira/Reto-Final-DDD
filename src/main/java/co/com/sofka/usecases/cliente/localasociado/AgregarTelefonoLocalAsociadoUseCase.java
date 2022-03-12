package co.com.sofka.usecases.cliente.localasociado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.localasociado.AgregarTelefonoLocalAsociado;

public class AgregarTelefonoLocalAsociadoUseCase extends UseCase<RequestCommand<AgregarTelefonoLocalAsociado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTelefonoLocalAsociado> input) {
        var comando = input.getCommand();
        var cliente = Cliente.form(comando.getClienteID(), retrieveEvents());

        cliente.agregarTelefonoLocalAsociado(
                comando.getLocalAsociadoID(),
                comando.getTelefono()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
