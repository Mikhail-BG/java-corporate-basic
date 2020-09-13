package corporate.basic.task.model.carriage;

import java.util.Objects;
import java.util.UUID;

import corporate.basic.task.model.BaseModel;

public abstract class Carriage extends BaseModel {
    private final String id;
    protected static int carriageCounter = 1;

    protected Carriage() {
        this.id = UUID.randomUUID().toString().substring(0, 5) + "-" + carriageCounter;
        carriageCounter++;
    }

    public String getId() {
        return id;
    }

    public String getInfo() {
        return this.getClass().getSimpleName() + ": " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carriage carriage = (Carriage) o;

        return Objects.equals(id, carriage.id);
    }

    @Override
    public int hashCode() {
        return id != null
                ? id.hashCode()
                : 0;
    }
}
