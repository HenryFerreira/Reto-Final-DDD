package co.com.sofka.retofinal.encargadoventa.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class MetaAgregada extends DomainEvent {
    private final MetaID metaID;
    private final Objetivo objetivo;
    private final Bonificacion bonificacion;

    public MetaAgregada(MetaID metaID, Objetivo objetivo, Bonificacion bonificacion) {
        super("sofka.encargadoventa.metaagregada");
        this.metaID = metaID;
        this.objetivo = objetivo;
        this.bonificacion = bonificacion;
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
