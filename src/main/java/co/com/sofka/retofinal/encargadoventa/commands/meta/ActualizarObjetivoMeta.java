package co.com.sofka.retofinal.encargadoventa.commands.meta;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class ActualizarObjetivoMeta extends Command {
    private final EncargadoVentaID encargadoVentaID;
    private final MetaID metaID;
    private final Objetivo objetivo;

    public ActualizarObjetivoMeta(EncargadoVentaID encargadoVentaID, MetaID metaID, Objetivo objetivo) {
        this.encargadoVentaID = encargadoVentaID;
        this.metaID = metaID;
        this.objetivo = objetivo;
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
}
