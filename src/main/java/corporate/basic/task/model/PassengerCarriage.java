package corporate.basic.task.model;

import java.util.Arrays;

public class PassengerCarriage extends Carriage {
    private Passenger[] passengers;

    public PassengerCarriage(Passenger... passengers) {
        super(CarriageType.PASSENGER);

        this.passengers = passengers;
    }

    @Override
    public String getInfo() {
        StringBuilder passengersInfo = new StringBuilder();

        for (Passenger passenger : passengers){
            passengersInfo.append("Passenger: ").append(passenger);
        }

        return super.getInfo() + "\n" + passengersInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerCarriage that = (PassengerCarriage) o;
        return Arrays.equals(passengers, that.passengers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(passengers);
    }
}
