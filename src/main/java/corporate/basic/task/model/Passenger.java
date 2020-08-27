package corporate.basic.task.model;

import java.util.Objects;

public class Passenger extends BaseModel {
    private final String firstName;
    private final String lastName;

    public Passenger(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return firstName.equals(passenger.firstName) &&
                lastName.equals(passenger.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
