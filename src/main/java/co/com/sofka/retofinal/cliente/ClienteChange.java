package co.com.sofka.retofinal.cliente;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.retofinal.cliente.events.*;

import java.util.ArrayList;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {

        apply((ClienteCreado evento) -> {
            cliente.nombre = evento.getNombre();
            cliente.direccion = evento.getDireccion();
            cliente.localesAsociados = new ArrayList<>();
            cliente.compras = new ArrayList<>();
        });

        apply((CompraAgregada evento) -> {
            cliente.compras.add(new Compra(
                    evento.getCompraID(),
                    evento.getVehiculoID(),
                    evento.getEncargadoVentaID(),
                    evento.getFechaPago(),
                    evento.getMonto()
            ));
        });

        apply((LocalAsociadoAgregado evento) -> {
            cliente.localesAsociados.add(new LocalAsociado(
                    evento.getLocalAsociadoID(),
                    evento.getNombre(),
                    evento.getTelefonos()
            ));
        });

        apply((DireccionActualizada evento) -> {
            cliente.direccion = evento.getDireccion();
        });

        apply((NombreActualizado evento) -> {
            cliente.nombre = evento.getNombre();
        });
    }
}
