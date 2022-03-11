package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.ActualizarNombre;

public class ActualizarNombreUseCase extends UseCase<RequestCommand<ActualizarNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombre> input) {
        var comando = input.getCommand();
        var cliente = Cliente.form(comando.getClienteID(), retrieveEvents());

        cliente.actualizarNombre(
                comando.getNombre()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
