package corporate.basic.task.manager;

import corporate.basic.task.model.Cargo;
import corporate.basic.task.model.Carriage;
import corporate.basic.task.model.Train;

public class TrainManager
{
    private final Train train;
    private final CarriageLoader carriageLoader;

    public TrainManager()
    {
        this.train = new Train();
        this.carriageLoader = new CarriageLoader(train.getCarriages());
    }

    public Train getTrain()
    {
        return train;
    }

    public TrainManager addCarriage(Carriage carriage)
    {
        train.getCarriages().add(carriage);

        return this;
    }

    public boolean addCargo(Cargo cargo)
    {
        return carriageLoader.addCargo(cargo);
    }
}
