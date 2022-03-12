package co.com.sofka.retofinal.encargadoventa.events.meta;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class ObjetivoMetaActualizado extends DomainEvent {
    private final MetaID metaID;
    private final Objetivo objetivo;

    public ObjetivoMetaActualizado(MetaID metaID, Objetivo objetivo) {
        super("sofka.encargadoventa.objetivometaactualizado");
        this.metaID = metaID;
        this.objetivo = objetivo;
    }

    public MetaID getMetaID() {
        return metaID;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }
}
