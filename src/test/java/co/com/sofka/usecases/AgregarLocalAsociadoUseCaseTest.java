package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.commands.AgregarLocalAsociado;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.events.LocalAsociadoAgregado;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.usecases.cliente.AgregarLocalAsociadoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarLocalAsociadoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarLocalAsociado() {
        ClienteID clienteID = ClienteID.of("xxxx");
        LocalAsociadoID localAsociadoID = LocalAsociadoID.of("yyyy");
        Nombre nombre = new Nombre("Nhox Soul");
        List<Telefono> telefonos = new ArrayList<>();
        telefonos.add(new Telefono(123456789));
        telefonos.add(new Telefono(987654321));
        telefonos.add(new Telefono(111222333));

        //ARRANGE
        var comando = new AgregarLocalAsociado(clienteID, localAsociadoID, nombre, telefonos);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AgregarLocalAsociadoUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (LocalAsociadoAgregado) events.get(0);
        Assertions.assertEquals("sofka.cliente.localasociadoagregado", event.type);
        Assertions.assertEquals("yyyy", event.getLocalAsociadoID().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("Nhox Soul", event.getNombre().value());
        Assertions.assertEquals(123456789, event.getTelefonos().get(0).value());
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