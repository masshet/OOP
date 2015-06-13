package by.masliakov.airline.entity;

/**
 * Created by mrstark on 22.5.15.
 */
public class Sportplane extends Plane {

    private String kindOfSport;

    public Sportplane() {}

    public Sportplane(int idPlane, int distance, int crew, double fuelConsumption, int capacity, String kindOfSport) {
        super(idPlane, distance, crew, fuelConsumption, capacity);
        setKindOfSport(kindOfSport);
    }

    public String getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(String kindOfSport) {
        if (kindOfSport != null) {
            this.kindOfSport = kindOfSport;
        }
    }

    public String toString() {
        return super.toString() + " " + getKindOfSport();
    }
}
