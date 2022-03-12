package co.com.sofka.retofinal.encargadoventa.commands.localtrabajo;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class ActualizarNombreLocalTrabajo extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final Nombre nombre;

    public ActualizarNombreLocalTrabajo(EncargadoVentaID encargadoVentaID, Nombre nombre) {
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
