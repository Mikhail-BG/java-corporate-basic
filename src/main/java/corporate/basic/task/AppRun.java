package corporate.basic.task;

import corporate.basic.task.manager.TrainManager;
import corporate.basic.task.model.Cargo;
import corporate.basic.task.model.Carriage;

public class AppRun
{
    public static void main(String[] args)
    {
        Cargo cargo1 = new Cargo("Cargo A", 100, 10);
        Cargo cargo2 = new Cargo("Cargo B", 200, 20);
        Cargo cargo3 = new Cargo("Cargo C", 300, 30);
        Cargo cargo4 = new Cargo("Cargo D", 100, 50);

        Carriage carriage1 = new Carriage(4000);
        Carriage carriage2 = new Carriage(5000);
        Carriage carriage3 = new Carriage(5000);
        Carriage carriage4 = new Carriage(8000);

        TrainManager trainManager = new TrainManager()
                .addCarriage(carriage1)
                .addCarriage(carriage2)
                .addCarriage(carriage3);

        System.out.println(trainManager.addCargo(cargo1));
        System.out.println(trainManager.getTrain());

        System.out.println(trainManager.addCargo(cargo2));
        System.out.println(trainManager.getTrain());

        System.out.println(trainManager.addCargo(cargo3));
        System.out.println(trainManager.getTrain());

        trainManager.addCarriage(carriage4);

        System.out.println(trainManager.addCargo(cargo4));
        System.out.println(trainManager.getTrain());
    }
}
