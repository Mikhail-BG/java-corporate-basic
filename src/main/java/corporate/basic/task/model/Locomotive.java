package corporate.basic.task.model;

import java.util.Objects;

public class Locomotive extends Carriage {

    private final int power;

    public Locomotive(int power) {
        super(CarriageType.LOCOMOTIVE);

        this.power = power;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n" + "Could hold up to: " + power + " carriages.";
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return power == that.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power);
    }
}
