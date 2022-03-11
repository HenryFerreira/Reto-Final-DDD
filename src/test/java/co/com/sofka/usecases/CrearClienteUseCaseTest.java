package co.com.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retofinal.cliente.commands.CrearCliente;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Calle;
import co.com.sofka.retofinal.genericos.direccion.Ciudad;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.genericos.direccion.NroPuerta;
import co.com.sofka.usecases.cliente.CrearClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearClienteUseCaseTest {
    @Test
    void crearCliente() {
        //ARRANGE
        ClienteID clienteID = ClienteID.of("xxxx");
        Nombre nombre = new Nombre("Henry Ferreira");
        Direccion direccion = new Direccion(
                new Calle("Andres cheveste"),
                new Ciudad("Artigas"),
                new NroPuerta("430Bis")
        );
        CrearCliente crearCliente = new CrearCliente(clienteID, nombre, direccion);

        //ACT
        CrearClienteUseCase useCase = new CrearClienteUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearCliente))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        Direccion direccionPrueba = new Direccion(
                new Calle("Andres cheveste"),
                new Ciudad("Artigas"),
                new NroPuerta("430Bis")
        );

        var event = (ClienteCreado) events.get(0);
        Assertions.assertEquals("sofka.cliente.clientecreado", event.type);
        Assertions.assertEquals("Henry Ferreira", event.getNombre().value());
        Assertions.assertEquals(direccionPrueba.value(), event.getDireccion().value());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }

}