package co.com.sofka.retofinal.encargadoventa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;

public class ActualizarNombre extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final Nombre nombre;

    public ActualizarNombre(EncargadoVentaID encargadoVentaID, Nombre nombre) {
        this.encargadoVentaID = encargadoVentaID;
        this.nombre = nombre;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
