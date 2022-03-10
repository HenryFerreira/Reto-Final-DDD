package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

import java.util.List;

public class LocalAsociado extends Entity<LocalAsociadoID> {

    private final Nombre nombre;
    private final List<Telefono> telefonos;

    public LocalAsociado(LocalAsociadoID localAsociadoID, Nombre nombre, List<Telefono> telefonos) {
        super(localAsociadoID);
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }
}
