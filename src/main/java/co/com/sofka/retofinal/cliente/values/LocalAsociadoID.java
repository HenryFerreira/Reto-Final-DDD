package co.com.sofka.retofinal.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class LocalAsociadoID extends Identity {
    public LocalAsociadoID() {

    }

    private LocalAsociadoID(String id) {
        super(id);
    }

    public static LocalAsociadoID of(String id) {
        return new LocalAsociadoID(id);
    }
}
