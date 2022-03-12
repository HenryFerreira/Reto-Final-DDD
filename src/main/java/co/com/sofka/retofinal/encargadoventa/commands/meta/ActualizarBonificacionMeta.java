package co.com.sofka.retofinal.encargadoventa.commands.meta;

import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.direccion.Direccion;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class ActualizarBonificacionMeta {
    private final EncargadoVentaID encargadoVentaID;
    private final MetaID metaID;
    private final Bonificacion bonificacion;

    public ActualizarBonificacionMeta(EncargadoVentaID encargadoVentaID, MetaID metaID, Bonificacion bonificacion) {
        this.encargadoVentaID = encargadoVentaID;
        this.metaID = metaID;
        this.bonificacion = bonificacion;
    }

    public EncargadoVentaID getEncargadoVentaID() {
        return encargadoVentaID;
    }

    public MetaID getMetaID() {
        return metaID;
    }

    public Bonificacion getBonificacion() {
        return bonificacion;
    }
}
