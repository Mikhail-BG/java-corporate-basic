package corporate.basic.task.model;

public class Cargo extends BaseModel {
    private final String description;
    private final int weight;
    private int quantity;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalCargoWeight() {
        return weight * quantity;
    }
}
