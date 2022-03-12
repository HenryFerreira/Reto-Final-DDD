package co.com.sofka.retofinal.vehiculo.events.fichatecnica;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;

public class DescripcionFichaTecnicaActualizada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionFichaTecnicaActualizada(Descripcion descripcion) {
        super("sofka.vehiculo.descripcionfichatecnicaactualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
