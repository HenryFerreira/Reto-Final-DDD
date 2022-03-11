package co.com.sofka.usecases.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.AgregarLocalAsociado;

public class AgregarLocalAsociadoUseCase extends UseCase<RequestCommand<AgregarLocalAsociado>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarLocalAsociado> input) {
        var comando = input.getCommand();
        var cliente = Cliente.form(comando.getClienteID(), retrieveEvents());

        cliente.agregarLocalAsociado(
                comando.getLocalAsociadoID(),
                comando.getNombre(),
                comando.getTelefonos()
        );

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
