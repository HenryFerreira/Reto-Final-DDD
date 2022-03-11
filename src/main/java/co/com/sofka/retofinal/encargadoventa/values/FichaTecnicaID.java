package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.Identity;

public class FichaTecnicaID extends Identity {
    public FichaTecnicaID() {

    }

    private FichaTecnicaID(String id) {
        super(id);
    }

    public static FichaTecnicaID of(String id) {
        return new FichaTecnicaID(id);
    }
}
