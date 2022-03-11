package co.com.sofka.usecases.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.commands.AgregarCompra;

public class AgregarCompraUseCase extends UseCase<RequestCommand<AgregarCompra>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCompra> input) {
        var comando = input.getCommand();
        var cliente = Cliente.form(comando.getClienteID(), retrieveEvents());

        cliente.agregarCompra(
                comando.getCompraID(),
                comando.getVehiculoID(),
                comando.getEncargadoVentaID(),
                comando.getFechaPago(),
                comando.getMonto()
        );
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
