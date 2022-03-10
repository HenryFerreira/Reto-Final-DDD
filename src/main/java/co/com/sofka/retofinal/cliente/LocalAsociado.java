package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.cliente.values.LocalAsociadoID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.Telefono;

import java.util.List;
import java.util.Objects;

public class LocalAsociado extends Entity<LocalAsociadoID> {

    private Nombre nombre;
    private List<Telefono> telefonos;

    public LocalAsociado(LocalAsociadoID localAsociadoID, Nombre nombre, List<Telefono> telefonos) {
        super(localAsociadoID);
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
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

    public List<Telefono> telefonos() {
        return telefonos;
    }
}
