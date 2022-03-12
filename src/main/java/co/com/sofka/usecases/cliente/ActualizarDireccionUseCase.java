package co.com.sofka.usecases.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.ActualizarDireccion;

public class ActualizarDireccionUseCase extends UseCase<RequestCommand<ActualizarDireccion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDireccion> input) {
        var comando = input.getCommand();
        var cliente = Cliente.form(comando.getClienteID(), retrieveEvents());

        cliente.actualizarDirccion(
                comando.getDireccion()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
