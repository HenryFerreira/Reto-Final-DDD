package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.events.MetaAgregada;
import co.com.sofka.retofinal.encargadoventa.events.NombreActualizado;
import co.com.sofka.retofinal.encargadoventa.events.VentaAgregada;

import java.util.ArrayList;

public class EncargadoVentaChange extends EventChange {
    public EncargadoVentaChange(EncargadoVenta encargadoVenta) {
        apply((EncargadoVentaCreado evento) -> {
            encargadoVenta.nombre = evento.getNombre();
            encargadoVenta.localTrabajo = evento.getLocalTrabajo();
            encargadoVenta.ventas = new ArrayList<>();
            encargadoVenta.metas = new ArrayList<>();
        });

        apply((MetaAgregada evento) -> {
            encargadoVenta.metas.add(new Meta(
                    evento.getMetaID(),
                    evento.getObjetivo(),
                    evento.getBonificacion()
            ));
        });

        apply((VentaAgregada evento) -> {
            encargadoVenta.ventas.add(new Venta(
                    evento.getVentaID(),
                    evento.getVehiculoID(),
                    evento.getClienteID(),
                    evento.getFechaVenta(),
                    evento.getMonto()
            ));
        });

        apply((NombreActualizado evento) -> {
            encargadoVenta.nombre = evento.getNombre();
        });

    }
}
