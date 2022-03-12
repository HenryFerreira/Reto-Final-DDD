package co.com.sofka.usecases.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.commands.ActualizarDireccion;
import co.com.sofka.retofinal.cliente.commands.ActualizarNombre;
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
class ActualizarDireccionUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDireccion() {
        //ARRANGE
        ClienteID clienteID = ClienteID.of("xxxx");
        Direccion direccion = new Direccion(
                new Calle("Burgo de los no muertos"),
                new Ciudad("Astora"),
                new NroPuerta("3DS")
        );
        var comando = new ActualizarDireccion(clienteID, direccion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new ActualizarDireccionUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        Direccion direccionPrueba = new Direccion(
                new Calle("Burgo de los no muertos"),
                new Ciudad("Astora"),
                new NroPuerta("3DS")
        );

        var event = (DireccionActualizada) events.get(0);
        Assertions.assertEquals("sofka.cliente.direccionactualizada", event.type);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(direccionPrueba.value(), event.getDireccion().value());


    }

    private List<DomainEvent> events() {
        Nombre nombre = new Nombre("Rhea Soul");
        Direccion direccion = new Direccion(
                new Calle("Avenida siempre vida"),
                new Ciudad("Lordran"),
                new NroPuerta("1DS")
        );
        return List.of(new ClienteCreado(nombre, direccion));
    }
}