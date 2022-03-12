package co.com.sofka.usecases.vehiculo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retofinal.cliente.events.ClienteCreado;
import co.com.sofka.retofinal.encargadoventa.values.FichaTecnicaID;
import co.com.sofka.retofinal.encargadoventa.values.MatriculacionID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;
import co.com.sofka.retofinal.vehiculo.commands.CrearVehiculo;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;
import co.com.sofka.retofinal.vehiculo.values.FechaMatriculacion;
import co.com.sofka.retofinal.vehiculo.values.Matricula;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.usecases.cliente.CrearClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrearVehiculoUseCaseTest {
    @Test
    void crearVehiculo() {
        //ARRANGE
        VehiculoID vehiculoID = VehiculoID.of("aaaa");
        Matriculacion matriculacion = new Matriculacion(
                MatriculacionID.of("mmmm"),
                VehiculoID.of("aaaa"),
                new Matricula("HAFF-1999"),
                new FechaMatriculacion(new Date("03/12/1999"))
        );
        FichaTecnica fichaTecnica = new FichaTecnica(
                FichaTecnicaID.of("ffff"),
                new Nombre("Ficha tecnica 1"),
                new Descripcion("Funcionando de momento")
        );
        CrearVehiculo crearVehiculo = new CrearVehiculo(vehiculoID, matriculacion, fichaTecnica);

        //ACT
        CrearVehiculoUseCase useCase = new CrearVehiculoUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearVehiculo))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT

        String pruebaDescripcion =
                "Detalles de la Matriculación: \n" +
                "Identificador de la Matriculación: mmmm\n" +
                "Identificador del Vehiculo: aaaa\n" +
                "Matricula asignada: HAFF-1999\n" +
                "Fecha de la matriculación: " + new Date("03/12/1999");

        var event = (VehiculoCreado) events.get(0);
        Assertions.assertEquals("sofka.vehiculo.vehiculocreado", event.type);
        Assertions.assertEquals("aaaa", event.aggregateRootId());

        Assertions.assertEquals("aaaa", event.getMatriculacion().vehiculoID().value());
        Assertions.assertEquals("mmmm", event.getMatriculacion().identity().value());
        Assertions.assertEquals("HAFF-1999", event.getMatriculacion().matricula().value());
        Assertions.assertEquals(new Date("03/12/1999"), event.getMatriculacion().fechaMatriculacion().value());
        Assertions.assertEquals(pruebaDescripcion, event.getMatriculacion().detallesMatriculacion());

        Assertions.assertEquals("ffff", event.getFichaTecnica().identity().value());
        Assertions.assertEquals("Ficha tecnica 1", event.getFichaTecnica().nombre().value());
        Assertions.assertEquals("Funcionando de momento", event.getFichaTecnica().descripcion().value());
    }

}