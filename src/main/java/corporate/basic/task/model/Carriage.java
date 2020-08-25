package corporate.basic.task.model;

import java.util.HashMap;
import java.util.Map;

public class Carriage extends BaseModel {
    private static final String LABEL = "CARRIAGE-0";
    private static int carriageCounter = 1;

    private final String id;
    private final Map<String, Integer> cargoDescriptions;
    private int capacity;

    public Carriage(int capacity) {
        this.id = LABEL + carriageCounter++;
        this.capacity = capacity;
        this.cargoDescriptions = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<String, Integer> getCargoDescriptions() {
        return cargoDescriptions;
    }

    public void addCargo(Cargo cargo) {
        int cargoCounter = 0;

        // Cargo could be loaded if there is a free capacity and cargo is not loaded fully
        while (canHandle(cargo) && cargo.getQuantity() > 0) {
            loadCargo(cargo, ++cargoCounter);
        }
    }

    public void removeCargo(Cargo cargo) {
        String cargoDescription = cargo.getDescription();

        if (cargoDescriptions.get(cargo.getDescription()) == null) {
            return;
        }

        while (cargoDescriptions.get(cargoDescription) > 0) {
            unloadCargo(cargo);
        }

        if (cargoDescriptions.get(cargoDescription) == 0){
            cargoDescriptions.remove(cargoDescription);
        }
    }

    private boolean canHandle(Cargo cargo) {
        return capacity >= cargo.getWeight();
    }

    private void loadCargo(Cargo cargo, int cargoCounter) {
        cargoDescriptions.put(cargo.getDescription(), cargoCounter);
        capacity -= cargo.getWeight();
        cargo.setQuantity(cargo.getQuantity() - 1);
    }

    private void unloadCargo(Cargo cargo) {
        String cargoDescription = cargo.getDescription();
        cargoDescriptions.put(cargoDescription, cargoDescriptions.get(cargoDescription) - 1);
        capacity += cargo.getWeight();
        cargo.setQuantity(cargo.getQuantity() + 1);
    }
}
