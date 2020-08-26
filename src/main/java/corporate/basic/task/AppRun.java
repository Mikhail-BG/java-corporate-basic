package corporate.basic.task;

import corporate.basic.task.model.Cargo;
import corporate.basic.task.model.Carriage;
import corporate.basic.task.model.Train;

public class AppRun {
    public static void main(String[] args) {
        Cargo cargo1 = new Cargo("Cargo A", 100, 10);
        Cargo cargo2 = new Cargo("Cargo B", 200, 20);
        Cargo cargo3 = new Cargo("Cargo C", 300, 30);
        Cargo cargo4 = new Cargo("Cargo D", 100, 50);

        Carriage carriage1 = new Carriage(1);
        Carriage carriage2 = new Carriage(2);
        Carriage carriage3 = new Carriage(3);
        Carriage carriage4 = new Carriage(4);

        Train train = new Train();
        train.addCarriage(carriage1);
        train.addCarriage(carriage2);
        train.addCarriage(carriage3);
        train.addCarriage(carriage4);

        carriage1.addCargos(cargo1, cargo2, cargo3, cargo4);
        carriage2.addCargos(cargo1, cargo2, cargo3, cargo4);
        carriage3.addCargos(cargo1, cargo2, cargo3, cargo4);
        carriage4.addCargos(cargo1, cargo2, cargo3, cargo4);

        System.out.println(train);

        carriage1.removeCargo(cargo2);
        carriage3.removeCargo(cargo1);

        train.removeCarriage(carriage4);

        System.out.println(train);
    }
}
