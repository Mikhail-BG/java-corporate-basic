package corporate.basic.task.model.carriage;

import java.util.Objects;

import corporate.basic.task.exception.OverloadCapacityException;
import corporate.basic.task.model.Passenger;
import corporate.basic.task.storage.ContainerList;

public class PassengerCarriage extends Carriage {
    private final int capacity;
    private final ContainerList<Passenger> passengers;

    public PassengerCarriage(int capacity) {
        super();
        this.passengers = new ContainerList<>();
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        StringBuilder passengersInfo = new StringBuilder();

        for (Passenger passenger : passengers) {
            passengersInfo.append("Passenger: ").append(passenger);
        }

        return super.getInfo() + "\n" + passengersInfo.toString();
    }

    public boolean addPassengers(Passenger... passengersToAdd) throws OverloadCapacityException {
        canHandle(passengersToAdd.length);

        boolean isAdded = false;
        for (Passenger cargo : passengersToAdd) {
            isAdded = passengers.add(cargo);
        }

        return isAdded;
    }

    public boolean addPassenger(Passenger passenger) throws OverloadCapacityException {
        canHandle(1);

        return passengers.add(passenger);
    }

    public boolean removePassenger(Passenger cargo) {
        return passengers.remove(cargo);
    }

    private void canHandle(int passengersToAdd) throws OverloadCapacityException {
        int currentCapacity = capacity - passengers.getSize();
        if (currentCapacity < passengersToAdd) {
            throw new OverloadCapacityException(this, currentCapacity, passengersToAdd);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCarriage that = (PassengerCarriage) o;

        if (capacity != that.capacity) return false;
        return Objects.equals(passengers, that.passengers);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + (passengers != null ? passengers.hashCode() : 0);
        return result;
    }
}
