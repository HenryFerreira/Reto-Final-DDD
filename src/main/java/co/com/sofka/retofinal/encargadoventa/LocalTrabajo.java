package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.vehiculo.values.LocalTrabajoID;

import java.util.List;
import java.util.Objects;

public class LocalTrabajo extends Entity<LocalTrabajoID> {
    private Nombre nombre;
    private Direccion direccion;
    private List<Telefono> telefonos;

    public LocalTrabajo(LocalTrabajoID localTrabajoID, Nombre nombre, Direccion direccion, List<Telefono> telefonos) {
        super(localTrabajoID);
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarDireccion(Direccion direccion) {
        this.direccion = Objects.requireNonNull(direccion);
    }

    public void listarTelefonos() {
        System.out.println("Lista de Telefonos: \n");
        for (Telefono elemento : this.telefonos) {
            System.out.println(elemento.value());
        }
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
