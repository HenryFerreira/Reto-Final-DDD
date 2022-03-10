package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.MatriculacionID;
import co.com.sofka.retofinal.vehiculo.values.FechaMatriculacion;
import co.com.sofka.retofinal.vehiculo.values.Matricula;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class Matriculacion extends Entity<MatriculacionID> {
    private final VehiculoID vehiculoID;
    private final Matricula matricula;
    private final FechaMatriculacion fechaMatriculacion;

    public Matriculacion(MatriculacionID matriculacionID, VehiculoID vehiculoID,
                         Matricula matricula, FechaMatriculacion fechaMatriculacion) {
        super(matriculacionID);
        this.vehiculoID = vehiculoID;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String detallesMatriculacion() {
        return "Detalles de la Matriculación: \n" +
                "Identificador de la Matriculación: " + this.entityId.value() + "\n" +
                "Identificador del Vehiculo: " + this.vehiculoID.value() + "\n" +
                "Matricula asignada: " + this.matricula.value() + "\n" +
                "Fecha de la matriculación: " + this.fechaMatriculacion.value();
    }


    public VehiculoID vehiculoID() {
        return vehiculoID;
    }

    public Matricula matricula() {
        return matricula;
    }

    public FechaMatriculacion fechaMatriculacion() {
        return fechaMatriculacion;
    }
}
