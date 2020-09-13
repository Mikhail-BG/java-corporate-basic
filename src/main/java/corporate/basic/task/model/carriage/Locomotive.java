package corporate.basic.task.model.carriage;

public class Locomotive extends Carriage {

    private final int power;

    public Locomotive(int power) {
        super();
        this.power = power;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n" + "Could hold up to: " + power + " carriages.\n";
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Locomotive that = (Locomotive) o;

        return power == that.power;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + power;
        return result;
    }
}
