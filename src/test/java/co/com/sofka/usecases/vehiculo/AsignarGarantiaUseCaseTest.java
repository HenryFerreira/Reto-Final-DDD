package co.com.sofka.usecases.vehiculo;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.events.NombreActualizado;
import co.com.sofka.retofinal.encargadoventa.values.FichaTecnicaID;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.encargadoventa.values.MatriculacionID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;
import co.com.sofka.retofinal.vehiculo.commands.AsignarGarantia;
import co.com.sofka.retofinal.vehiculo.events.GarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.values.*;
import co.com.sofka.usecases.encargadoventa.ActualizarNombreUseCase;
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
class AsignarGarantiaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void asignarGarantia() {
        //ARRANGE
        VehiculoID vehiculoID = VehiculoID.of("vvvv");
        GarantiaID garantiaID = GarantiaID.of("gggg");
        FechaEmision fechaEmision = new FechaEmision(new Date("11/09/2002"));
        FechaVigencia fechaVigencia = new FechaVigencia(new Date("11/09/2012"));
        ;
        var comando = new AsignarGarantia(vehiculoID, garantiaID, fechaEmision, fechaVigencia);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AsignarGarantiaUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (GarantiaAsignada) events.get(0);
        Assertions.assertEquals("sofka.vehiculo.garantiaasignada", event.type);
        Assertions.assertEquals("vvvv", event.aggregateRootId());
        Assertions.assertEquals("gggg", event.getGarantiaID().value());
        Assertions.assertEquals(new Date("11/09/2002"), event.getFechaEmision().value());
        Assertions.assertEquals(new Date("11/09/2012"), event.getFechaVigencia().value());
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