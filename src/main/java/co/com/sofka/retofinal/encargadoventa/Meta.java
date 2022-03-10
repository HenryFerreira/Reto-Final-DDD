package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.Objetivos;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

public class Meta extends Entity<MetaID> {
    private final Objetivos objetivos;
    private final Bonificacion bonificacion;

    public Meta(MetaID metaID, Objetivos objetivos, Bonificacion bonificacion) {
        super(metaID);
        this.objetivos = objetivos;
        this.bonificacion = bonificacion;
    }

    public Objetivos getObjetivos() {
        return objetivos;
    }

    public Bonificacion getBonificacion() {
        return bonificacion;
    }
}
