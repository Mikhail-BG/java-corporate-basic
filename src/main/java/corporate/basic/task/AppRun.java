package corporate.basic.task;

import corporate.basic.task.model.*;

public class AppRun {
    public static void main(String[] args) {
        Cargo cargo1 = new Cargo("Cargo A", 100, 10);
        Cargo cargo2 = new Cargo("Cargo B", 200, 20);
        Cargo cargo3 = new Cargo("Cargo C", 300, 30);
        Cargo cargo4 = new Cargo("Cargo D", 100, 50);

        Passenger passenger1 = new Passenger("CHRIS", "EVANS");
        Passenger passenger2 = new Passenger("JENNIFER", "LAWRENCE");
        Passenger passenger3 = new Passenger("CHANNING", "TATUM");
        Passenger passenger4 = new Passenger("JOHNNY", "DEPP");


        Locomotive locomotive1 = new Locomotive(5);
        Locomotive locomotive2 = new Locomotive(4);

        FreightCarriage freightCarriage1 = new FreightCarriage(1);
        FreightCarriage freightCarriage2 = new FreightCarriage(2);
        FreightCarriage freightCarriage3 = new FreightCarriage(3);
        FreightCarriage freightCarriage4 = new FreightCarriage(4);

        PassengerCarriage passengerCarriage1 = new PassengerCarriage(passenger1, passenger2);
        PassengerCarriage passengerCarriage2 = new PassengerCarriage(passenger3, passenger4);

        Train train = new Train(locomotive1);
        train.addAnotherCarriage(freightCarriage1);
        train.addAnotherCarriage(freightCarriage2);
        train.addAnotherCarriage(freightCarriage3);
        train.addAnotherCarriage(passengerCarriage1);
        train.addAnotherCarriage(passengerCarriage2);

        freightCarriage1.addCargos(cargo1, cargo2, cargo3, cargo4);
        freightCarriage2.addCargos(cargo1, cargo2, cargo3, cargo4);
        freightCarriage3.addCargos(cargo1, cargo2, cargo3, cargo4);
        freightCarriage4.addCargos(cargo1, cargo2, cargo3, cargo4);

        System.out.println(train.prettyPrint());

        freightCarriage1.removeCargo(cargo2);
        freightCarriage3.removeCargo(cargo1);
        train.replaceLocomotive(locomotive2);

        System.out.println(train.prettyPrint());

        train.removeCarriage(freightCarriage4);
        train.removeCarriage(passengerCarriage2);
        train.replaceLocomotive(locomotive2);

        System.out.println(train.prettyPrint());
    }
}
