package co.com.sofka.retofinal.vehiculo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;

public class VehiculoCreado extends DomainEvent {
    private final Matriculacion matriculacion;
    private final FichaTecnica fichaTecnica;

    public VehiculoCreado(Matriculacion matriculacion, FichaTecnica fichaTecnica) {
        super("sofka.vehiculo.vehiculocreado");
        this.matriculacion = matriculacion;
        this.fichaTecnica = fichaTecnica;
    }

    public Matriculacion getMatriculacion() {
        return matriculacion;
    }
    
    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }
}
