package corporate.basic.task.model;

import java.util.Arrays;

public class FreightCarriage extends Carriage {
    private final Cargo[] cargos;

    public FreightCarriage(int capacity) {
        super(CarriageType.FREIGHT);
        this.cargos = new Cargo[capacity];
    }

    @Override
    public String getInfo() {

        StringBuilder cargosInfo = new StringBuilder();

        for (Cargo cargo : cargos){
            cargosInfo.append("Cargo: ").append(cargo);
        }

        return super.getInfo() + "\n" + cargosInfo.toString();
    }

    public boolean addCargos(Cargo... cargos){
        boolean isAdded = false;
        for (Cargo cargo : cargos){
            isAdded = addCargo(cargo);

            if (!isAdded){
                break;
            }
        }

        return isAdded;
    }

    public boolean addCargo(Cargo cargo) {
        boolean isAdded = false;
        for (int index = 0; index < cargos.length; index++){
            if (cargos[index] == null){
                cargos[index] = cargo;
                isAdded = true;
                break;
            }
        }

        return isAdded;
    }

    public boolean removeCargo(Cargo cargo) {
        boolean isRemoved = false;

        for (int index = 0; index < cargos.length; index++){
            if (cargos[index] == cargo){
                cargos[index] = null;
                isRemoved = true;
                break;
            }
        }

        return isRemoved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreightCarriage that = (FreightCarriage) o;
        return Arrays.equals(cargos, that.cargos);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cargos);
    }
}
