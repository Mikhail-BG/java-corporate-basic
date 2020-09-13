package corporate.basic.task.model.carriage;

import java.util.Objects;

import corporate.basic.task.exception.OverloadCapacityException;
import corporate.basic.task.model.Cargo;
import corporate.basic.task.storage.ContainerList;

public class FreightCarriage extends Carriage {
    private final int capacity;
    private final ContainerList<Cargo> cargos;

    public FreightCarriage(int capacity) {
        super();
        this.cargos = new ContainerList<>();
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        StringBuilder cargosInfo = new StringBuilder();

        for (Cargo cargo : cargos){
            cargosInfo.append("Cargo: ").append(cargo);
        }

        return super.getInfo() + "\n" + cargosInfo.toString();
    }

    public boolean addCargos(Cargo... cargosToAdd) throws OverloadCapacityException {
        canHandle(cargosToAdd);

        boolean isAdded = false;
        for (Cargo cargo : cargosToAdd) {
            isAdded = cargos.add(cargo);
        }

        return isAdded;

    }

    public boolean addCargo(Cargo cargo) throws OverloadCapacityException {
        canHandle(cargo);

        return cargos.add(cargo);
    }

    public boolean removeCargo(Cargo cargo) {
        return cargos.remove(cargo);
    }

    private void canHandle(Cargo... cargosToAdd) throws OverloadCapacityException {
        int currentCapacity = capacity - cargos.getSize();
        int requiredCapacity = cargosToAdd.length;
        if (currentCapacity < requiredCapacity) {
            throw new OverloadCapacityException(this, currentCapacity, requiredCapacity);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FreightCarriage that = (FreightCarriage) o;

        if (capacity != that.capacity) return false;
        return Objects.equals(cargos, that.cargos);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + (cargos != null ? cargos.hashCode() : 0);
        return result;
    }
}
