package co.com.sofka.retofinal.encargadoventa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.LocalTrabajo;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;

public class CrearEncargadoVenta extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final Nombre nombre;
    private final LocalTrabajo localTrabajo;

    public CrearEncargadoVenta(EncargadoVentaID encargadoVentaID, Nombre nombre, LocalTrabajo localTrabajo) {
        this.encargadoVentaID = encargadoVentaID;
        this.nombre = nombre;
        this.localTrabajo = localTrabajo;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public LocalTrabajo getLocalTrabajo() {
        return localTrabajo;
    }
}
