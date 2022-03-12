package co.com.sofka.usecases.encargadoventa;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.encargadoventa.LocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.commands.AgregarVenta;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.events.MetaAgregada;
import co.com.sofka.retofinal.encargadoventa.events.VentaAgregada;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.encargadoventa.values.FechaVenta;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.retofinal.vehiculo.values.LocalTrabajoID;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.retofinal.vehiculo.values.VentaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarVentaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarVenta() {
        //ARRANGE
        EncargadoVentaID encargadoVentaID = EncargadoVentaID.of("rrrr");
        VentaID ventaID = VentaID.of("dddd");
        VehiculoID vehiculoID = VehiculoID.of("xxxx");
        ClienteID clienteID = ClienteID.of("cccc");
        FechaVenta fechaVenta = new FechaVenta(new Date("11/03/2000"));
        Monto monto = new Monto(7800D);
        var comando = new AgregarVenta(encargadoVentaID, ventaID, vehiculoID, clienteID, fechaVenta, monto);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AgregarVentaUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (VentaAgregada) events.get(0);
        Assertions.assertEquals("sofka.encargadoventa.ventaagregada", event.type);
        Assertions.assertEquals("rrrr", event.aggregateRootId());
        Assertions.assertEquals("xxxx", event.getVehiculoID().value());
        Assertions.assertEquals("cccc", event.getClienteID().value());
        Assertions.assertEquals(new Date("11/03/2000"), event.getFechaVenta().value());
        Assertions.assertEquals("dddd", event.getVentaID().value());
        Assertions.assertEquals(7800D, event.getMonto().value());

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