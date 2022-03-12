package co.com.sofka.usecases.cliente.localasociado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.commands.localasociado.AgregarTelefonoLocalAsociado;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.events.localasociado.NombreLocalAsociadoActualizado;
import co.com.sofka.retofinal.cliente.events.localasociado.TelefonoAgregadoLocalAsociado;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
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
class AgregarTelefonoLocalAsociadoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarTelefonoLocalAsociado() {
        //ARRANGE
        ClienteID clienteID = ClienteID.of("cccc");
        LocalAsociadoID localAsociadoID = LocalAsociadoID.of("llll");
        Telefono telefono = new Telefono(222555888);
        var comando = new AgregarTelefonoLocalAsociado(clienteID, localAsociadoID, telefono);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AgregarTelefonoLocalAsociadoUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (TelefonoAgregadoLocalAsociado) events.get(0);
        Assertions.assertEquals("sofka.cliente.telefonoagregadoLocalasociado", event.type);
        Assertions.assertEquals("cccc", event.aggregateRootId());
        Assertions.assertEquals("llll", event.getLocalAsociadoID().value());
        Assertions.assertEquals(222555888, event.getTelefono().value());

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