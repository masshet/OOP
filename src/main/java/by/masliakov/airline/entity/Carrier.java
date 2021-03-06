package by.masliakov.airline.entity;

/**
 * Created by mrstark on 21.5.15.
 */
public class Carrier extends Plane {

    private String typeOfCargo;

    public Carrier() {}

    public Carrier(int idPlane, int maxDistance, int crew, double fuelConsumption, int capacity, String typeOfCargo) {
        super(idPlane, maxDistance, crew, fuelConsumption, capacity);
        setTypeOfCargo(typeOfCargo);
    }

    public String getTypeOfCargo() {
        return typeOfCargo;
    }

    public void setTypeOfCargo(String typeOfCargo) {
        if (typeOfCargo != null) {
            this.typeOfCargo = typeOfCargo;
        }
    }

    public String toString() {
        return super.toString() + " " + getTypeOfCargo();
    }
}
