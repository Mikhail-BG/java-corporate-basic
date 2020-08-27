package corporate.basic.task.model;

public abstract class Carriage extends BaseModel {
    private final String id;

    protected static final String LABEL = "-CARRIAGE-0";
    protected static int carriageCounter = 1;

    protected Carriage(CarriageType carriageType) {
        this.id = carriageType.getCode() + LABEL + carriageCounter;
        carriageCounter++;
    }

    public String getId() {
        return id;
    }

    public String getInfo(){
        return id;
    }

    public enum CarriageType{
        FREIGHT("FRGT"),
        PASSENGER("PASS"),
        LOCOMOTIVE("LOCO");

        private final String code;

        CarriageType(String code){
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
