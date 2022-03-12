package co.com.sofka.retofinal.encargadoventa.commands.localtrabajo;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.genericos.direccion.Direccion;

public class AgregarTelefonoLocalTrabajo extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final Telefono telefono;

    public AgregarTelefonoLocalTrabajo(EncargadoVentaID encargadoVentaID, Telefono telefono) {
        this.encargadoVentaID = encargadoVentaID;
        this.telefono = telefono;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
