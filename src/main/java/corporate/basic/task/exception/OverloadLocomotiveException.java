package corporate.basic.task.exception;

import corporate.basic.task.model.carriage.Locomotive;

public class OverloadLocomotiveException extends OverloadException {
    public OverloadLocomotiveException(Locomotive locomotive, int requiredCapacity){
        super("Locomotive power is not enough: " + locomotive.getId() + " with power: " + locomotive.getPower() +
                ", required power: " + requiredCapacity);
    }
}
