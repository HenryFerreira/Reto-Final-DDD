package co.com.sofka.retofinal.vehiculo.values;

import co.com.sofka.domain.generic.Identity;

public class MetaID extends Identity {
    public MetaID() {

    }

    private MetaID(String id) {
        super(id);
    }

    public static MetaID of(String id) {
        return new MetaID(id);
    }
}
