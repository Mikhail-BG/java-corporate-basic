package corporate.basic.task.manager;

import java.util.List;

import corporate.basic.task.model.Cargo;
import corporate.basic.task.model.Carriage;

public class CarriageLoader
{
    private final List<Carriage> carriages;

    public CarriageLoader(List<Carriage> carriages)
    {
        this.carriages = carriages;
    }

    public boolean addCargo(Cargo cargo)
    {
        boolean isLoaded = false;

        for (Carriage carriage: carriages)
        {
            if (isCargoPut(carriage, cargo))
            {
                carriage.setCapacity(carriage.getCapacity() - calcTotalCargoWeight(cargo));
                carriage.getCargos().add(cargo);
                isLoaded = true;
                break;
            }
        }

        return isLoaded;
    }

    private boolean isCargoPut(Carriage carriage, Cargo cargo)
    {
        return carriage.getCapacity() >= calcTotalCargoWeight(cargo);
    }

    private int calcTotalCargoWeight(Cargo cargo)
    {
        return cargo.getWeight() * cargo.getQuantity();
    }
}
