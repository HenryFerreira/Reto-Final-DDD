package co.com.sofka.usecases.encargadoventa.localtrabajo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.LocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.commands.AgregarMeta;
import co.com.sofka.retofinal.encargadoventa.commands.localtrabajo.AgregarTelefonoLocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.events.MetaAgregada;
import co.com.sofka.retofinal.encargadoventa.events.localtrabajo.TelefonoLocalTrabajoAgregado;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.retofinal.vehiculo.values.LocalTrabajoID;
import co.com.sofka.retofinal.vehiculo.values.MetaID;
import co.com.sofka.usecases.encargadoventa.AgregarMetaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarTelefonoLocalTrabajoUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarTelefonoLocalTrabajo() {
        //ARRANGE
        EncargadoVentaID encargadoVentaID = EncargadoVentaID.of("vvvv");
        Telefono telefono = new Telefono(111222333);
        var comando = new AgregarTelefonoLocalTrabajo(encargadoVentaID, telefono);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AgregarTelefonoLocalTrabajoUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();
        //ASSERT
        var event = (TelefonoLocalTrabajoAgregado) events.get(0);
        Assertions.assertEquals("sofka.encargadoventa.telefonolocaltrabajoagregado", event.type);
        Assertions.assertEquals("vvvv", event.aggregateRootId());
        Assertions.assertEquals(111222333, event.getTelefono().value());
    }

    private List<DomainEvent> events() {
        Nombre nombre = new Nombre("Pedro");

        List<Telefono> telefonos = new ArrayList<>();
        telefonos.add(new Telefono(333666999));
        LocalTrabajo localTrabajo = new LocalTrabajo(
                LocalTrabajoID.of("cccc"),
                new Nombre("AutoShop"),
                new Direccion(
                        new Calle("Calle1"),
                        new Ciudad("Lordran"),
                        new NroPuerta("444")
                ),
                telefonos
        );
        return List.of(new EncargadoVentaCreado(nombre, localTrabajo));
    }
}