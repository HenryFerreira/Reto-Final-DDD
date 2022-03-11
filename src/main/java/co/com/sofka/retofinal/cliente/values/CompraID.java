package co.com.sofka.retofinal.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class CompraID extends Identity {
    public CompraID() {

    }

    private CompraID(String id) {
        super(id);
    }

    public static CompraID of(String id) {
        return new CompraID(id);
    }
}
