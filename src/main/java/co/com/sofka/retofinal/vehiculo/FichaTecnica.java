package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.FichaTecnicaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.values.Descripcion;

import java.util.Objects;

public class FichaTecnica extends Entity<FichaTecnicaID> {
    private Nombre nombre;
    private Descripcion descripcion;

    public FichaTecnica(FichaTecnicaID fichaTecnicaID, Nombre nombre, Descripcion descripcion) {
        super(fichaTecnicaID);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
