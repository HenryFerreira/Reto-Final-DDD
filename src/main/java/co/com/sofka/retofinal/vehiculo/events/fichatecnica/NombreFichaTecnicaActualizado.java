package co.com.sofka.retofinal.vehiculo.events.fichatecnica;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class NombreFichaTecnicaActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreFichaTecnicaActualizado(Nombre nombre) {
        super("sofka.vehiculo.nombrefichatecnicaactualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
