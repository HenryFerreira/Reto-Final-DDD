package co.com.sofka.retofinal.encargadoventa;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retofinal.cliente.values.ClienteID;
import co.com.sofka.retofinal.encargadoventa.events.EncargadoVentaCreado;
import co.com.sofka.retofinal.encargadoventa.events.MetaAgregada;
import co.com.sofka.retofinal.encargadoventa.events.NombreActualizado;
import co.com.sofka.retofinal.encargadoventa.events.VentaAgregada;
import co.com.sofka.retofinal.encargadoventa.values.Bonificacion;
import co.com.sofka.retofinal.encargadoventa.values.EncargadoVentaID;
import co.com.sofka.retofinal.encargadoventa.values.FechaVenta;
import co.com.sofka.retofinal.encargadoventa.values.Objetivo;
import co.com.sofka.retofinal.genericos.Monto;
import co.com.sofka.retofinal.genericos.Nombre;
import co.com.sofka.retofinal.vehiculo.values.MetaID;
import co.com.sofka.retofinal.vehiculo.values.VehiculoID;
import co.com.sofka.retofinal.vehiculo.values.VentaID;

import java.util.List;
import java.util.Objects;

public class EncargadoVenta extends AggregateEvent<EncargadoVentaID> {
    protected List<Venta> ventas;
    protected List<Meta> metas;
    protected LocalTrabajo localTrabajo;
    protected Nombre nombre;

    public EncargadoVenta(EncargadoVentaID encargadoVentaID, Nombre nombre, LocalTrabajo localTrabajo) {
        super(encargadoVentaID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(localTrabajo);
        appendChange(new EncargadoVentaCreado(nombre, localTrabajo)).apply();
    }

    private EncargadoVenta(EncargadoVentaID encargadoVentaID) {
        super(encargadoVentaID);
        subscribe(new EncargadoVentaChange(this));
    }

    public static EncargadoVenta form(EncargadoVentaID encargadoVentaID, List<DomainEvent> eventos) {
        var encargadoVenta = new EncargadoVenta(encargadoVentaID);
        eventos.forEach(encargadoVenta::applyEvent);
        return encargadoVenta;

    }

    public void agregarVenta(VentaID ventaID, VehiculoID vehiculoID, ClienteID clienteID,
                             FechaVenta fechaVenta, Monto monto) {
        Objects.requireNonNull(ventaID);
        Objects.requireNonNull(vehiculoID);
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(fechaVenta);
        Objects.requireNonNull(monto);
        appendChange(new VentaAgregada(ventaID, vehiculoID, clienteID, fechaVenta, monto)).apply();
    }

    public void agregarMeta(MetaID metaID, Objetivo objetivo, Bonificacion bonificacion) {
        Objects.requireNonNull(metaID);
        Objects.requireNonNull(objetivo);
        Objects.requireNonNull(bonificacion);
        appendChange(new MetaAgregada(metaID, objetivo, bonificacion)).apply();
    }

    public void actualizarNombre(Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreActualizado(nombre)).apply();
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

    public List<Venta> ventas() {
        return ventas;
    }

    public List<Meta> metas() {
        return metas;
    }

    public LocalTrabajo localTrabajo() {
        return localTrabajo;
    }

    public Nombre nombre() {
        return nombre;
    }
}
