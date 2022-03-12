package co.com.sofka.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.events.DireccionActualizada;
import co.com.sofka.retofinal.cliente.events.NombreActualizado;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificarDireccionClienteActualizadaUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private SMSClienteService servicio;

    @Test
    void enviarMensajeConductor() {
        //ARRANGE
        var evento = new DireccionActualizada(new Direccion(
                new Calle("NUEVA CALLE"),
                new Ciudad("NUEVA CIUDAD"),
                new NroPuerta("5555")
        ));
        evento.setAggregateRootId("xxxx");
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensajeCliente(Mockito.any(ClienteID.class), Mockito.anyString())).thenReturn(true);

        //ACT
        var useCase = new NotificarDireccionClienteActualizadaUseCase();
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var isPresent = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(evento)).isPresent();
        Assertions.assertTrue(isPresent);
    }

    @Test
    void problemaConEnvioDeMensaje() {
        //ARRANGE
        var evento = new DireccionActualizada(new Direccion(
                new Calle("NUEVA CALLE"),
                new Ciudad("NUEVA CIUDAD"),
                new NroPuerta("5555")
        ));
        evento.setAggregateRootId("xxxx");
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(historico());
        Mockito.when(servicio.enviarMensajeCliente(Mockito.any(ClienteID.class), Mockito.anyString())).thenReturn(false);

        //ACT
        var useCase = new NotificarDireccionClienteActualizadaUseCase();
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(servicio));

        var mensaje = Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor("xxxx")
                    .syncExecutor(useCase, new TriggeredEvent<>(evento));
        }).getMessage();

        Assertions.assertEquals("No se pudo enviar el mensaje de cambio de direccion", mensaje);
    }

    private List<DomainEvent> historico() {
        Nombre nombre = new Nombre("Rhea Soul");
        Direccion direccion = new Direccion(
                new Calle("Avenida siempre vida"),
                new Ciudad("Lordran"),
                new NroPuerta("1DS")
        );
        return List.of(new ClienteCreado(nombre, direccion));
    }
}