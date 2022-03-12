package co.com.sofka.usecases.vehiculo;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retofinal.vehiculo.Vehiculo;
import co.com.sofka.retofinal.vehiculo.commands.CrearVehiculo;

public class CrearVehiculoUseCase extends UseCase<RequestCommand<CrearVehiculo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearVehiculo> input) {
        CrearVehiculo crearVehiculo = input.getCommand();

        Vehiculo vehiculo = new Vehiculo(
                crearVehiculo.getVehiculoID(),
                crearVehiculo.getMatriculacion(),
                crearVehiculo.getFichaTecnica()
        );
        emit().onResponse(new ResponseEvents(vehiculo.getUncommittedChanges()));
    }
}
