package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.MatriculacionID;
import co.com.sofka.retofinal.vehiculo.values.FechaMatriculacion;
import co.com.sofka.retofinal.vehiculo.values.Matricula;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class Matriculacion extends Entity<MatriculacionID> {
    private final MatriculacionID matriculacionID;
    private final VehiculoID vehiculoID;
    private final Matricula matricula;
    private final FechaMatriculacion fechaMatriculacion;

    public Matriculacion(MatriculacionID matriculacionID, VehiculoID vehiculoID,
                         Matricula matricula, FechaMatriculacion fechaMatriculacion) {
        super(matriculacionID);
        this.matriculacionID = matriculacionID;
        this.vehiculoID = vehiculoID;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public MatriculacionID getMatriculacionID() {
        return matriculacionID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public FechaMatriculacion getFechaMatriculacion() {
        return fechaMatriculacion;
    }
}
