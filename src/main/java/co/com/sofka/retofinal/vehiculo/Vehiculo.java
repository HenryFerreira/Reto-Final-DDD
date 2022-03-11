package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

import java.util.Objects;

public class Vehiculo extends AggregateEvent<VehiculoID> {
    protected FichaTecnica fichaTecnica;
    protected Matriculacion matriculacion;
    protected Garantia garantia;

    public Vehiculo(VehiculoID entityId, Matriculacion matriculacion) {
        super(entityId);
        appendChange(new VehiculoCreado()).apply();
        this.matriculacion = matriculacion;
    }

    public void detallesMatriculacion() {
        System.out.println(this.matriculacion.detallesMatriculacion());
    }

    public void detallesFichaTecnica() {
        System.out.println("Detalles de la Ficha Tecnica: \n");
        System.out.println(this.fichaTecnica.identity().value());
        System.out.println(this.fichaTecnica.nombre().value());
        System.out.println(this.fichaTecnica.descripcion().value());
    }

    public void asignarGarantia(Garantia garantia) {
        this.garantia = Objects.requireNonNull(garantia);
    }
}
