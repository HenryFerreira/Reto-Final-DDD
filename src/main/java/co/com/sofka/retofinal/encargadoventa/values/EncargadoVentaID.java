package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.Identity;

public class EncargadoVentaID extends Identity {
    public EncargadoVentaID() {

    }

    private EncargadoVentaID(String id) {
        super(id);
    }

    public static EncargadoVentaID of(String id) {
        return new EncargadoVentaID(id);
    }
}
