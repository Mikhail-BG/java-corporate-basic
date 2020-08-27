package corporate.basic.task.model;

import java.util.Arrays;
import java.util.Random;

public class Train extends BaseModel {
    private static final Random RANDOM = new Random();
    private static final String LABEL = "TRAIN-";

    private final String guid;

    private Carriage[] carriages;
    private Locomotive locomotive;

    public Train(Locomotive locomotive) {
        this.guid = LABEL + RANDOM.nextInt(100);
        this.locomotive = locomotive;
        this.carriages = new Carriage[locomotive.getPower()];
    }

    public String getGuid() {
        return guid;
    }

    public String prettyPrint(){
        StringBuilder stringBuilder = new StringBuilder("Train: ");
        stringBuilder.append(getGuid()).append("\n");
        stringBuilder.append(locomotive.getInfo()).append("\n");

        for (Carriage carriage : carriages){
            if (carriage != null){
                stringBuilder.append(carriage.getInfo());
            }
        }

        return stringBuilder.toString();
    }

    public void replaceLocomotive(Locomotive locomotive) {
        if (getNumberOfFullSlots() <= locomotive.getPower()) {
            this.locomotive = locomotive;
            this.carriages = Arrays.copyOf(this.carriages, locomotive.getPower());
        }
    }

    public boolean addAnotherCarriage(Carriage carriage) {
        boolean isAdded = false;
        if (hasFreeSlot()) {
            isAdded = addCarriage(carriage);
        }

        return isAdded;
    }

    public boolean removeCarriage(Carriage carriage) {
        boolean isRemoved = false;
        int index = 0;
        for (Carriage slot : carriages) {
            if (slot.equals(carriage)) {
                carriages[index] = null;
                isRemoved = true;
            }
            index += 1;
        }

        return isRemoved;
    }

    private boolean addCarriage(Carriage carriage) {
        boolean isAdded = false;
        int index = 0;
        for (Carriage slot : carriages) {
            if (slot == null) {
                carriages[index] = carriage;
                isAdded = true;
                break;
            }
            index += 1;
        }

        return isAdded;
    }

    private boolean hasFreeSlot() {
        boolean hasSlot = false;
        for (Carriage carriage : carriages) {
            if (carriage == null) {
                hasSlot = true;
                break;
            }
        }

        return hasSlot;
    }

    private int getNumberOfFullSlots(){
        int number = 0;
        for (Carriage carriage : carriages){
            if (carriage != null){
                number ++;
            }
        }

        return number;
    }
}
