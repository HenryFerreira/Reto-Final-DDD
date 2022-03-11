package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.Identity;

public class VentaID extends Identity {
    public VentaID() {

    }

    private VentaID(String id) {
        super(id);
    }

    public static VentaID of(String id) {
        return new VentaID(id);
    }
}
