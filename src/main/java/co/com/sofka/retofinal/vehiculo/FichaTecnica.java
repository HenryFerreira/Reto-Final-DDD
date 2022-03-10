package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.FichaTecnicaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;

public class FichaTecnica extends Entity<FichaTecnicaID> {
    private final Nombre nombre;
    private final Descripcion descripcion;

    public FichaTecnica(FichaTecnicaID fichaTecnicaID, Nombre nombre, Descripcion descripcion) {
        super(fichaTecnicaID);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
