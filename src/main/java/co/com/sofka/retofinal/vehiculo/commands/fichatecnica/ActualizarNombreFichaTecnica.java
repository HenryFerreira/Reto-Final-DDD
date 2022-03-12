package co.com.sofka.retofinal.vehiculo.commands.fichatecnica;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class ActualizarNombreFichaTecnica extends Command {
    private final VehiculoID vehiculoID;
    private final Nombre nombre;

    public ActualizarNombreFichaTecnica(VehiculoID vehiculoID, Nombre nombre) {
        this.vehiculoID = vehiculoID;
        this.nombre = nombre;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
