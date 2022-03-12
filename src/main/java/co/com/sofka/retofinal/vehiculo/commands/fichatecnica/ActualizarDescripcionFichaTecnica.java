package co.com.sofka.retofinal.vehiculo.commands.fichatecnica;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class ActualizarDescripcionFichaTecnica extends Command {
    private final VehiculoID vehiculoID;
    private final Descripcion descripcion;

    public ActualizarDescripcionFichaTecnica(VehiculoID vehiculoID, Descripcion descripcion) {
        this.vehiculoID = vehiculoID;
        this.descripcion = descripcion;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
