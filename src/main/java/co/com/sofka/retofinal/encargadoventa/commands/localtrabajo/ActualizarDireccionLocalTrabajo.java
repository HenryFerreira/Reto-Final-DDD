package co.com.sofka.retofinal.encargadoventa.commands.localtrabajo;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class ActualizarDireccionLocalTrabajo extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final Direccion direccion;

    public ActualizarDireccionLocalTrabajo(EncargadoVentaID encargadoVentaID, Direccion direccion) {
        this.encargadoVentaID = encargadoVentaID;
        this.direccion = direccion;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
