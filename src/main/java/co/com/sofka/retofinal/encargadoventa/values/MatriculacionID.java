package co.com.sofka.retofinal.encargadoventa.values;

import co.com.sofka.domain.generic.Identity;

public class MatriculacionID extends Identity {
    public MatriculacionID() {

    }

    private MatriculacionID(String id) {
        super(id);
    }

    public static MatriculacionID of(String id) {
        return new MatriculacionID(id);
    }
}
