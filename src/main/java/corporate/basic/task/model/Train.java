package corporate.basic.task.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Train extends BaseModel {
    private static final Random RANDOM = new Random();
    private static final String LABEL = "TRAIN-";

    private final String guid;
    private final List<Carriage> carriages;

    public Train() {
        this.guid = LABEL + RANDOM.nextInt(100);
        this.carriages = new ArrayList<>();
    }

    public String getGuid() {
        return guid;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void addCarriage(Carriage carriage) {
        this.carriages.add(carriage);
    }

    public void removeCarriage(Carriage carriage) {
        this.carriages.remove(carriage);
    }
}
