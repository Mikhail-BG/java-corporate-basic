package corporate.basic.task.model;

import java.util.Objects;
import java.util.Random;

import corporate.basic.task.exception.OverloadLocomotiveException;
import corporate.basic.task.model.carriage.Carriage;
import corporate.basic.task.model.carriage.Locomotive;
import corporate.basic.task.storage.ContainerList;

public class Train extends BaseModel {
    private static final Random RANDOM = new Random();
    private static final String LABEL = "TRAIN-";

    private final String guid;

    private final ContainerList<Carriage> carriages;

    public Train(Locomotive locomotive) {
        this.guid = LABEL + RANDOM.nextInt(100);
        this.carriages = new ContainerList<>();
        this.carriages.setFirst(locomotive);
    }

    public String getGuid() {
        return guid;
    }

    public String prettyPrint() {
        StringBuilder stringBuilder = new StringBuilder("Train: ");
        stringBuilder.append(getGuid()).append("\n");

        for (Carriage carriage : carriages) {
            stringBuilder.append(carriage.getInfo());
        }

        return stringBuilder.toString();
    }

    public void replaceLocomotive(Locomotive locomotive) throws OverloadLocomotiveException {
        // Power is required for current train, '-1' means except locomotive
        int requiredPower = carriages.getSize() - 1;
        if (requiredPower <= locomotive.getPower()) {
            this.removeCarriage(carriages.getFirst());
            this.carriages.setFirst(locomotive);
        } else {
            throw new OverloadLocomotiveException(locomotive, requiredPower);
        }
    }

    public boolean removeCarriage(Carriage carriage) {
        return carriages.remove(carriage);
    }

    public boolean addCarriage(Carriage carriage) throws OverloadLocomotiveException {
        boolean isAdded;
        if (hasFreeSlot()) {
            isAdded = carriages.add(carriage);
        } else {
            throw new OverloadLocomotiveException((Locomotive) carriages.getFirst(), carriages.getSize());
        }

        return isAdded;
    }

    private boolean hasFreeSlot() {
        return ((Locomotive) carriages.getFirst()).getPower() >= carriages.getSize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (!Objects.equals(guid, train.guid)) return false;
        return Objects.equals(carriages, train.carriages);
    }

    @Override
    public int hashCode() {
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (carriages != null ? carriages.hashCode() : 0);
        return result;
    }
}
