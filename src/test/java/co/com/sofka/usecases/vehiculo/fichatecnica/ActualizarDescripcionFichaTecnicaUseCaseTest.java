package co.com.sofka.usecases.vehiculo.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.FichaTecnicaID;
import co.com.sofka.retofinal.encargadoventa.values.MatriculacionID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;
import co.com.sofka.retofinal.vehiculo.commands.CrearVehiculo;
import co.com.sofka.retofinal.vehiculo.commands.fichatecnica.ActualizarDescripcionFichaTecnica;
import co.com.sofka.retofinal.vehiculo.events.GarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.events.fichatecnica.DescripcionFichaTecnicaActualizada;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;
import co.com.sofka.retofinal.vehiculo.values.FechaMatriculacion;
import co.com.sofka.retofinal.vehiculo.values.Matricula;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.usecases.vehiculo.AsignarGarantiaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActualizarDescripcionFichaTecnicaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDescripcionFichaTecnica() {
        //ARRANGE
        VehiculoID vehiculoID = VehiculoID.of("vvvv");
        Descripcion descripcion = new Descripcion("DESCRIPCION NUEVA");
        var comando = new ActualizarDescripcionFichaTecnica(vehiculoID, descripcion);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new ActualizarDescripcionFichaTecnicaUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (DescripcionFichaTecnicaActualizada) events.get(0);
        Assertions.assertEquals("sofka.vehiculo.descripcionfichatecnicaactualizada", event.type);
        Assertions.assertEquals("vvvv", event.aggregateRootId());
        Assertions.assertEquals("DESCRIPCION NUEVA", event.getDescripcion().value());

    }

    private List<DomainEvent> events() {
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
        return List.of(new VehiculoCreado(matriculacion, fichaTecnica));
    }
}