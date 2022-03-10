package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;

public class EncargadoVenta extends AggregateEvent<EncargadoVentaID> {
    public EncargadoVenta(EncargadoVentaID encargadoVentaID, Nombre nombre) {
        super(encargadoVentaID);
    }
}
