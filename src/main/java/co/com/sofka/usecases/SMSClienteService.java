package co.com.sofka.usecases;

import co.com.sofka.retofinal.cliente.values.ClienteID;

public interface SMSClienteService {
    boolean enviarMensajeCliente(ClienteID clienteID, String mensaje);
}
