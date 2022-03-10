package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.vehiculo.values.LocalTrabajoID;

import java.util.List;

public class LocalTrabajo extends Entity<LocalTrabajoID> {
    private final Nombre nombre;
    private final Direccion direccion;
    private final List<Telefono> telefonos;

    public LocalTrabajo(LocalTrabajoID localTrabajoID, Nombre nombre, Direccion direccion, List<Telefono> telefonos) {
        super(localTrabajoID);
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Direccion direccion() {
        return direccion;
    }

    public List<Telefono> telefonos() {
        return telefonos;
    }
}
