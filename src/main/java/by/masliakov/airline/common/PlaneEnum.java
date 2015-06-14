package by.masliakov.airline.common;

/**
 * Created by mrstark on 11.6.15.
 */
public enum PlaneEnum {
    AIRLINE("airline"),
    PLANE("plane"),
    DISTANCE("distance"),
    CREW("crew"),
    FUEL("fuel"),
    CAPACITY("capacity"),
    PASS("pass"),
    CARGO("cargo"),
    DISCHARGE("discharge"),
    SPORT("sport"),
    COMPANY("company"),
    TYPE("type"),
    ID("id");
    private String value;
    private PlaneEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
