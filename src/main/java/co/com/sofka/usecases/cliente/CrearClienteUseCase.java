package co.com.sofka.usecases.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> input) {
        CrearCliente crearCliente = input.getCommand();

        Cliente cliente = new Cliente(
                crearCliente.getClienteID(),
                crearCliente.getNombre(),
                crearCliente.getDireccion()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
