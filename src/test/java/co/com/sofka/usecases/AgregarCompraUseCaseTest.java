package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.commands.AgregarCompra;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.events.CompraAgregada;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.cliente.values.CompraID;
import co.com.sofka.retofinal.cliente.values.FechaPago;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.usecases.cliente.AgregarCompraUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class AgregarCompraUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void agregarCompra() {
        //ARRANGE
        ClienteID clienteID = ClienteID.of("xxxx");
        CompraID compraID = CompraID.of("xxxy");
        VehiculoID vehiculoID = VehiculoID.of("xxyy");
        EncargadoVentaID encargadoVentaID = EncargadoVentaID.of("xyyy");
        FechaPago fechaPago = new FechaPago(new Date("03/11/2022"));
        Monto monto = new Monto(18000D);

        var comando = new AgregarCompra(clienteID, compraID, vehiculoID, encargadoVentaID, fechaPago, monto);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AgregarCompraUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (CompraAgregada) events.get(0);
        Assertions.assertEquals("sofka.cliente.compraagregada", event.type);
        Assertions.assertEquals("xxxy", event.getCompraID().value());
        Assertions.assertEquals("xxyy", event.getVehiculoID().value());
        Assertions.assertEquals("xyyy", event.getEncargadoVentaID().value());
        Assertions.assertEquals(new FechaPago(new Date("03/11/2022")).value(), event.getFechaPago().value());
        Assertions.assertEquals(18000D, event.getMonto().value());

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