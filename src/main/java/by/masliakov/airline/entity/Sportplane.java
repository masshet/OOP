package by.masliakov.airline.entity;

/**
 * Created by mrstark on 22.5.15.
 */
public class Sportplane extends Plane {

    private String kindOfSport;

    public Sportplane(int idPlane, int distance, int numOfEngine, String name,
                      int crew, double fuelConsumption, int capacity, String kindOfSport) {
        super(idPlane, distance, numOfEngine, name, crew, fuelConsumption, capacity);
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
}
