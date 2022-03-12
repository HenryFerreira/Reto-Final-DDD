package co.com.sofka.retofinal.encargadoventa.events.meta;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.genericos.Telefono;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class BonificacionMetaActualizada extends DomainEvent {
    private final MetaID metaID;
    private final Bonificacion bonificacion;

    public BonificacionMetaActualizada(MetaID metaID, Bonificacion bonificacion) {
        super("sofka.encargadoventa.bonificacionmetaactualizada");
        this.metaID = metaID;
        this.bonificacion = bonificacion;
    }

    public MetaID getMetaID() {
        return metaID;
    }

    public Bonificacion getBonificacion() {
        return bonificacion;
    }
}
