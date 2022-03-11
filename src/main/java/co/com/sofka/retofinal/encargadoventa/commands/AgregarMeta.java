package co.com.sofka.retofinal.encargadoventa.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class AgregarMeta extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final MetaID metaID;
    private final Objetivo objetivo;
    private final Bonificacion bonificacion;

    public AgregarMeta(EncargadoVentaID encargadoVentaID, MetaID metaID, Objetivo objetivo, Bonificacion bonificacion) {
        this.encargadoVentaID = encargadoVentaID;
        this.metaID = metaID;
        this.objetivo = objetivo;
        this.bonificacion = bonificacion;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public MetaID getMetaID() {
        return metaID;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public Bonificacion getBonificacion() {
        return bonificacion;
    }
}
