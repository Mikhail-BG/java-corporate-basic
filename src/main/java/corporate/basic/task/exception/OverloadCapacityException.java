package corporate.basic.task.exception;

import corporate.basic.task.model.carriage.Carriage;

public class OverloadCapacityException extends OverloadException {
    public OverloadCapacityException(Carriage carriage, int currentCapacity, int requiredCapacity) {
        super("Capacity limit exceeded: for carriage: " + carriage.getId() + ", current capacity: " +
                currentCapacity + ", required capacity: " + requiredCapacity);
    }
}
