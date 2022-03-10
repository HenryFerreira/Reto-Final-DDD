package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;

import java.util.List;

public class EncargadoVenta extends AggregateEvent<EncargadoVentaID> {
    protected List<Venta> ventas;
    protected List<Meta> metas;
    protected LocalTrabajo localTrabajo;
    protected Nombre nombre;

    public EncargadoVenta(EncargadoVentaID encargadoVentaID, Nombre nombre) {
        super(encargadoVentaID);
    }
}
