package co.com.sofka.usecases.encargadoventa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retofinal.encargadoventa.LocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.commands.CrearEncargadoVenta;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.retofinal.vehiculo.values.LocalTrabajoID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class CrearEncargadoVentaUseCaseTest {
    @Test
    void crearEncargadoVenta() {
        //ARRANGE
        EncargadoVentaID encargadoVentaID = EncargadoVentaID.of("xxxx");
        Nombre nombre = new Nombre("Jose");
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
        CrearEncargadoVenta crearEncargadoVenta = new CrearEncargadoVenta(encargadoVentaID, nombre, localTrabajo);

        //ACT
        CrearEncargadoVentaUseCase useCase = new CrearEncargadoVentaUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearEncargadoVenta))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        Direccion direccionPrueba = new Direccion(
                new Calle("Calle1"),
                new Ciudad("Lordran"),
                new NroPuerta("444")
        );

        var event = (EncargadoVentaCreado) events.get(0);
        Assertions.assertEquals("sofka.encargadoventa.encargadoventacreado", event.type);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("Jose", event.getNombre().value());
        Assertions.assertEquals("AutoShop", event.getLocalTrabajo().nombre().value());
        Assertions.assertEquals("cccc", event.getLocalTrabajo().identity().value());
        Assertions.assertEquals(direccionPrueba.value(), event.getLocalTrabajo().direccion().value());
        Assertions.assertEquals(333666999, event.getLocalTrabajo().telefonos().get(0).value());
    }
}