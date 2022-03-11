package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.retofinal.cliente.Compra;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.genericos.Nombre;

import java.util.List;
import java.util.Objects;

public class EncargadoVenta extends AggregateEvent<EncargadoVentaID> {
    protected List<Venta> ventas;
    protected List<Meta> metas;
    protected LocalTrabajo localTrabajo;
    protected Nombre nombre;

    public EncargadoVenta(EncargadoVentaID encargadoVentaID, Nombre nombre) {
        super(encargadoVentaID);
        appendChange(new EncargadoVentaCreado(nombre)).apply();
    }

    public void listarVentas() {
        System.out.println("Lista de Ventas: \n");
        for (Venta elemento : this.ventas) {
            System.out.println(elemento.detallesVenta());
        }
    }

    public void listarMetas() {
        System.out.println("Lista de Metas: \n");
        for (Meta elemento : this.metas) {
            System.out.println("Objetivo: " + elemento.objetivo().value());
            System.out.println("Beneficio: " + elemento.bonificacion().value());
        }
    }

    public void agregarVenta(Venta venta) {
        this.ventas.add(Objects.requireNonNull(venta));
    }

    public void agregarMeta(Meta meta) {
        this.metas.add(Objects.requireNonNull(meta));
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

}
