package corporate.basic.task;

import corporate.basic.task.exception.OverloadException;
import corporate.basic.task.model.Cargo;
import corporate.basic.task.model.Passenger;
import corporate.basic.task.model.Train;
import corporate.basic.task.model.carriage.FreightCarriage;
import corporate.basic.task.model.carriage.Locomotive;
import corporate.basic.task.model.carriage.PassengerCarriage;

public class AppRun {
    public static void main(String[] args) throws OverloadException {
        Cargo cargo1 = new Cargo("Cargo A", 100, 10);
        Cargo cargo2 = new Cargo("Cargo B", 200, 20);
        Cargo cargo3 = new Cargo("Cargo C", 300, 30);
        Cargo cargo4 = new Cargo("Cargo D", 100, 50);
        Cargo cargo5 = new Cargo("Cargo E", 400, 10);

        Passenger passenger1 = new Passenger("CHRIS", "EVANS");
        Passenger passenger2 = new Passenger("JENNIFER", "LAWRENCE");
        Passenger passenger3 = new Passenger("CHANNING", "TATUM");
        Passenger passenger4 = new Passenger("JOHNNY", "DEPP");

        Locomotive locomotive1 = new Locomotive(4);
        Locomotive locomotive2 = new Locomotive(6);
        Locomotive locomotive3 = new Locomotive(3);

        FreightCarriage freightCarriage1 = new FreightCarriage(1);
        FreightCarriage freightCarriage2 = new FreightCarriage(2);
        FreightCarriage freightCarriage3 = new FreightCarriage(3);
        FreightCarriage freightCarriage4 = new FreightCarriage(4);

        PassengerCarriage passengerCarriage1 = new PassengerCarriage(2);
        PassengerCarriage passengerCarriage2 = new PassengerCarriage(2);

        Train train = new Train(locomotive1);
        train.addCarriage(freightCarriage1);
        train.addCarriage(freightCarriage2);
        train.addCarriage(freightCarriage3);
        train.addCarriage(freightCarriage4);

        freightCarriage1.addCargos(cargo1);
        freightCarriage2.addCargos(cargo2, cargo3);
        freightCarriage3.addCargos(cargo4);
        freightCarriage4.addCargos(cargo5);

        passengerCarriage1.addPassengers(passenger1, passenger2);
        passengerCarriage2.addPassenger(passenger3);
        passengerCarriage2.addPassenger(passenger4);

        System.out.println(train.prettyPrint());

        freightCarriage1.removeCargo(cargo2);
        freightCarriage3.removeCargo(cargo1);
        train.replaceLocomotive(locomotive2);
        train.addCarriage(passengerCarriage1);
        train.addCarriage(passengerCarriage2);

        System.out.println(train.prettyPrint());

        train.removeCarriage(freightCarriage2);
        train.removeCarriage(freightCarriage4);
        train.removeCarriage(passengerCarriage1);
        passengerCarriage2.removePassenger(passenger4);
        train.replaceLocomotive(locomotive3);

        System.out.println(train.prettyPrint());
    }
}
