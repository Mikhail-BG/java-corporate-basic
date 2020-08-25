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

        Carriage carriage1 = new Carriage(4000);
        Carriage carriage2 = new Carriage(5000);
        Carriage carriage3 = new Carriage(5000);
        Carriage carriage4 = new Carriage(4000);

        Train train = new Train();
        train.addCarriage(carriage1);
        train.addCarriage(carriage2);
        train.addCarriage(carriage3);
        train.addCarriage(carriage4);

        carriage1.addCargo(cargo1);
        carriage1.addCargo(cargo2);
        carriage2.addCargo(cargo1);
        carriage2.addCargo(cargo2);
        carriage2.addCargo(cargo3);
        carriage3.addCargo(cargo3);
        carriage4.addCargo(cargo3);
        carriage4.addCargo(cargo4);

        System.out.println(train);

        System.out.println(carriage1);
        System.out.println(carriage2);
        System.out.println(carriage3);
        System.out.println(carriage4);

        System.out.println(cargo1);
        System.out.println(cargo2);
        System.out.println(cargo3);
        System.out.println(cargo4);

        carriage1.removeCargo(cargo1);
        carriage1.removeCargo(cargo2);

        train.removeCarriage(carriage3);

        System.out.println(train);

        System.out.println(carriage1);
        System.out.println(carriage2);
        System.out.println(carriage3);
        System.out.println(carriage4);

        System.out.println(cargo1);
        System.out.println(cargo2);
        System.out.println(cargo3);
        System.out.println(cargo4);
    }
}
