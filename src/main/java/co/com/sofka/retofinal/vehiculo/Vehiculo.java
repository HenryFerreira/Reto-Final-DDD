package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.vehiculo.events.GarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;
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

    public void asignarGarantia(GarantiaID garantiaID, FechaEmision fechaEmision, FechaVigencia fechaVigencia) {
        Objects.requireNonNull(garantiaID);
        Objects.requireNonNull(fechaEmision);
        Objects.requireNonNull(fechaVigencia);
        appendChange(new GarantiaAsignada(garantiaID, fechaEmision, fechaVigencia)).apply();
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

    public FichaTecnica fichaTecnica() {
        return fichaTecnica;
    }

    public Matriculacion matriculacion() {
        return matriculacion;
    }

    public Garantia garantia() {
        return garantia;
    }
}
