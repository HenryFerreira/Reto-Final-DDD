package co.com.sofka.retofinal.vehiculo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.vehiculo.FichaTecnica;
import co.com.sofka.retofinal.vehiculo.Matriculacion;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class CrearVehiculo extends Command {
    private final VehiculoID vehiculoID;
    private final Matriculacion matriculacion;
    private final FichaTecnica fichaTecnica;

    public CrearVehiculo(VehiculoID vehiculoID, Matriculacion matriculacion, FichaTecnica fichaTecnica) {
        this.vehiculoID = vehiculoID;
        this.matriculacion = matriculacion;
        this.fichaTecnica = fichaTecnica;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Matriculacion getMatriculacion() {
        return matriculacion;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }
}
