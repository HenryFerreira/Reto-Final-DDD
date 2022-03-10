package co.com.sofka.retofinal.vehiculo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;

public class Vehiculo extends AggregateEvent<VehiculoID> {
    protected FichaTecnica fichaTecnica;
    protected Matriculacion matriculacion;
    protected Garantia garantia;

    public Vehiculo(VehiculoID entityId) {
        super(entityId);
    }
}
