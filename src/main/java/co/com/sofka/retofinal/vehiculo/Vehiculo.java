package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.GarantiaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.events.GarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.events.VehiculoCreado;
import co.com.sofka.retofinal.vehiculo.events.fichatecnica.DescripcionFichaTecnicaActualizada;
import co.com.sofka.retofinal.vehiculo.events.fichatecnica.NombreFichaTecnicaActualizado;
import co.com.sofka.retofinal.vehiculo.events.garantia.FechaVigenciaGarantiaAsignada;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;
import co.com.sofka.retofinal.vehiculo.values.FechaEmision;
import co.com.sofka.retofinal.vehiculo.values.FechaVigencia;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

import java.util.List;
import java.util.Objects;

public class Vehiculo extends AggregateEvent<VehiculoID> {
    protected FichaTecnica fichaTecnica;
    protected Matriculacion matriculacion;
    protected Garantia garantia;

    public Vehiculo(VehiculoID vehiculoID, Matriculacion matriculacion, FichaTecnica fichaTecnica) {
        super(vehiculoID);
        appendChange(new VehiculoCreado(matriculacion, fichaTecnica)).apply();
        this.matriculacion = matriculacion;
        this.fichaTecnica = fichaTecnica;
    }

    private Vehiculo(VehiculoID vehiculoID) {
        super(vehiculoID);
        subscribe(new VehiculoChange(this));
    }

    public static Vehiculo form(VehiculoID vehiculoID, List<DomainEvent> eventos) {
        var vehiculo = new Vehiculo(vehiculoID);
        eventos.forEach(vehiculo::applyEvent);
        return vehiculo;
    }

    public void asignarGarantia(GarantiaID garantiaID, FechaEmision fechaEmision, FechaVigencia fechaVigencia) {
        Objects.requireNonNull(garantiaID);
        Objects.requireNonNull(fechaEmision);
        Objects.requireNonNull(fechaVigencia);
        appendChange(new GarantiaAsignada(garantiaID, fechaEmision, fechaVigencia)).apply();
    }

    public void asignarFechaVigenciaGarantia(FechaVigencia fechaVigencia) {
        Objects.requireNonNull(fechaVigencia);
        appendChange(new FechaVigenciaGarantiaAsignada(fechaVigencia)).apply();
    }

    public void actualizarNombreFichaTecnica(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreFichaTecnicaActualizado(nombre)).apply();
    }

    public void actualizarDescripcionFichaTecnica(Descripcion descripcion) {
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionFichaTecnicaActualizada(descripcion)).apply();
    }

    protected void detallesMatriculacion() {
        System.out.println(this.matriculacion.detallesMatriculacion());
    }

    protected void detallesFichaTecnica() {
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
