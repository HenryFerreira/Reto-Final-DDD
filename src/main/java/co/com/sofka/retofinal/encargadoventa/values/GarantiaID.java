package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.Identity;

public class GarantiaID extends Identity {
    public GarantiaID() {

    }

    private GarantiaID(String id) {
        super(id);
    }

    public static GarantiaID of(String id) {
        return new GarantiaID(id);
    }
}
