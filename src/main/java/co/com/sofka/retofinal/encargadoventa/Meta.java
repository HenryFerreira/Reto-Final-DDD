package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.vehiculo.values.MetaID;

import java.util.Objects;

public class Meta extends Entity<MetaID> {
    private Objetivo objetivo;
    private Bonificacion bonificacion;

    public Meta(MetaID metaID, Objetivo objetivo, Bonificacion bonificacion) {
        super(metaID);
        this.objetivo = objetivo;
        this.bonificacion = bonificacion;
    }

    public void actualizarObjetivo(Objetivo objetivo) {
        this.objetivo = Objects.requireNonNull(objetivo);
    }

    public void actualizarBonificacion(Bonificacion bonificacion) {
        this.bonificacion = Objects.requireNonNull(bonificacion);
    }

    public Objetivo objetivo() {
        return objetivo;
    }

    public Bonificacion bonificacion() {
        return bonificacion;
    }
}
