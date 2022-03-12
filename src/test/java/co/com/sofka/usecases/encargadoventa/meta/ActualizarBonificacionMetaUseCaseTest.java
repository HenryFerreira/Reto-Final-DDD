package co.com.sofka.usecases.encargadoventa.meta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.LocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.commands.localtrabajo.ActualizarNombreLocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.commands.meta.ActualizarBonificacionMeta;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.events.localtrabajo.NombreLocalTrabajoActualizado;
import co.com.sofka.retofinal.encargadoventa.events.meta.BonificacionMetaActualizada;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.retofinal.vehiculo.values.LocalTrabajoID;
import co.com.sofka.retofinal.vehiculo.values.MetaID;
import co.com.sofka.usecases.encargadoventa.localtrabajo.ActualizarNombreLocalTrabajoUseCase;
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
class ActualizarBonificacionMetaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarBonificacionMeta() {
        //ARRANGE
        EncargadoVentaID encargadoVentaID = EncargadoVentaID.of("eeee");
        MetaID metaID = MetaID.of("xxxx");
        Bonificacion bonificacion = new Bonificacion(65000D);
        var comando = new ActualizarBonificacionMeta(encargadoVentaID, metaID, bonificacion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new ActualizarBonificacionMetaUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (BonificacionMetaActualizada) events.get(0);
        Assertions.assertEquals("sofka.encargadoventa.bonificacionmetaactualizada", event.type);
        Assertions.assertEquals("eeee", event.aggregateRootId());
        Assertions.assertEquals("xxxx", event.getMetaID().value());
        Assertions.assertEquals(65000D, event.getBonificacion().value());

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