package co.com.sofka.usecases.vehiculo.garantia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.FichaTecnicaID;
import co.com.sofka.retofinal.encargadoventa.values.MatriculacionID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;
import co.com.sofka.retofinal.vehiculo.commands.garantia.AsignarFechaVigenciaGarantia;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.events.fichatecnica.NombreFichaTecnicaActualizado;
import co.com.sofka.retofinal.vehiculo.events.garantia.FechaVigenciaGarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.values.*;
import co.com.sofka.usecases.vehiculo.fichatecnica.ActualizarNombreFichaTecnicaUseCase;
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
class AsignarFechaVigenciaGarantiaUseCaseTest {
    @Mock
    DomainEventRepository repository;

    @Test
    void asignarFechaVigenciaGarantia() {
        //ARRANGE
        VehiculoID vehiculoID = VehiculoID.of("gggg");
        FechaVigencia fechaVigencia = new FechaVigencia(new Date("04/08/1999"));
        var comando = new AsignarFechaVigenciaGarantia(vehiculoID, fechaVigencia);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        //ACT
        var useCase = new AsignarFechaVigenciaGarantiaUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comando))
                .orElseThrow()
                .getDomainEvents();

        //ASSERT
        var event = (FechaVigenciaGarantiaAsignada) events.get(0);
        Assertions.assertEquals("sofka.vehiculo.fechavigenciagarantiaasignada", event.type);
        Assertions.assertEquals("gggg", event.aggregateRootId());
        Assertions.assertEquals(new Date("04/08/1999"), event.getFechaVigencia().value());

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