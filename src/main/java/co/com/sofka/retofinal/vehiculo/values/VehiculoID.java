package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.Identity;

public class VehiculoID extends Identity {
    public VehiculoID() {

    }

    private VehiculoID(String id) {
        super(id);
    }

    public static VehiculoID of(String id) {
        return new VehiculoID(id);
    }
}
