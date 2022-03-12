package co.com.sofka.usecases.cliente.localasociado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.localasociado.ActualizarNombreLocalAsociado;

public class ActualizarNombreLocalAsociadoUseCase extends UseCase<RequestCommand<ActualizarNombreLocalAsociado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreLocalAsociado> input) {
        var comando = input.getCommand();
        var cliente = Cliente.form(comando.getClienteID(), retrieveEvents());

        cliente.actualizarNombreLocalAsociado(
                comando.getLocalAsociadoID(),
                comando.getNombre()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
