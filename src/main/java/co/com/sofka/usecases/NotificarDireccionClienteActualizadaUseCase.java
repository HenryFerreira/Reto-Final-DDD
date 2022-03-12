package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.events.DireccionActualizada;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.usecases.SMSClienteService;

import java.util.List;

public class NotificarDireccionClienteActualizadaUseCase extends UseCase<TriggeredEvent<DireccionActualizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DireccionActualizada> input) {
        var evento = input.getDomainEvent();
        var servicio = getService(SMSClienteService.class).orElseThrow();

        var eventos = repository().getEventsBy(evento.aggregateRootId());
        var cliente = Cliente.form(ClienteID.of(evento.aggregateRootId()), eventos);

        var resultado = servicio.enviarMensajeCliente(cliente.identity(), "Se cambio la direccion del cliente");

        if (resultado) {
            emit().onResponse(new ResponseEvents(List.of()));
        } else {
            throw new BusinessException(evento.aggregateRootId(), "No se pudo enviar el mensaje de cambio de direccion");
        }
    }
}
