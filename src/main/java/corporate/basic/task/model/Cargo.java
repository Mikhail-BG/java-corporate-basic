package corporate.basic.task.model;

import java.util.Objects;

public class Cargo extends BaseModel {
    private final String description;
    private final int weight;
    private final int quantity;

    public Cargo(String description, int weight, int quantity) {
        this.description = description;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalCargoWeight() {
        return weight * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return weight == cargo.weight &&
                quantity == cargo.quantity &&
                description.equals(cargo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, quantity);
    }
}
