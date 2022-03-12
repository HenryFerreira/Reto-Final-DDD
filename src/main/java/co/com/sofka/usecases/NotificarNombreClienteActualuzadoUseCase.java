package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.retofinal.cliente.Cliente;
import co.com.sofka.retofinal.cliente.events.NombreActualizado;
import co.com.sofka.retofinal.cliente.values.ClienteID;

import java.util.List;

public class NotificarNombreClienteActualuzadoUseCase extends UseCase<TriggeredEvent<NombreActualizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<NombreActualizado> input) {
        var evento = input.getDomainEvent();
        var servicio = getService(SMSClienteService.class).orElseThrow();

        var eventos = repository().getEventsBy(evento.aggregateRootId());
        var cliente = Cliente.form(ClienteID.of(evento.aggregateRootId()), eventos);

        var resultado = servicio.enviarMensajeCliente(cliente.identity(), "Se cambio el nombre del cliente");

        if (resultado) {
            emit().onResponse(new ResponseEvents(List.of()));
        } else {
            throw new BusinessException(evento.aggregateRootId(), "No se pudo enviar el mensaje");
        }
    }
}
