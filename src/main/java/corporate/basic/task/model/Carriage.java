package corporate.basic.task.model;

public class Carriage extends BaseModel {
    private static final String LABEL = "CARRIAGE-0";
    private static int carriageCounter = 1;

    private final String id;
    private final Cargo[] cargos;

    private int capacityIndex;

    public Carriage(int capacity) {
        this.id = LABEL + carriageCounter++;
        this.cargos = new Cargo[capacity];
        this.capacityIndex = 0;
    }

    public String getId() {
        return id;
    }

    public boolean addCargos(Cargo... cargos){
        boolean isLoaded = false;
        for (Cargo cargo : cargos){
            isLoaded = addCargo(cargo);

            if (!isLoaded){
                break;
            }
        }

        return isLoaded;
    }

    public boolean addCargo(Cargo cargo) {
        boolean isLoaded = false;

        if (capacityIndex < cargos.length) {
            loadCargo(cargo);
            isLoaded = true;
        }

        return isLoaded;
    }

    public boolean removeCargo(Cargo cargo) {
        boolean isRemoved = false;

        int cargoIndex = 0;
        for (Cargo loadedCargo : cargos) {
            if (loadedCargo == cargo) {
                unloadCargo(cargoIndex);
                isRemoved = true;
                break;
            }
            cargoIndex += 1;
        }

        return isRemoved;
    }

    private void loadCargo(Cargo cargo) {
        cargos[capacityIndex] = cargo;
        capacityIndex += 1;
    }

    private void unloadCargo(int cargoIndex) {
        // Remove cargo from its position
        // Empty the last capacity cell
        if (cargoIndex < capacityIndex) {
            cargos[cargoIndex] = cargos[cargos.length - 1];
        }
        cargos[cargos.length - 1] = null;
        capacityIndex -= 1;
    }
}
