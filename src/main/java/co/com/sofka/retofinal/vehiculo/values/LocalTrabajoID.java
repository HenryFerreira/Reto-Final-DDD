package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.Identity;

public class LocalTrabajoID extends Identity {
    public LocalTrabajoID() {

    }

    private LocalTrabajoID(String id) {
        super(id);
    }

    public static LocalTrabajoID of(String id) {
        return new LocalTrabajoID(id);
    }
}
