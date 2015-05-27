package by.masliakov.airline.entity.plane;

/**
 * Created by mrstark on 22.5.15.
 */
public class Mailplane extends Plane {

    private String companyName;

    public Mailplane(int idPlane, int distance, int numOfEngine, String name,
                     int crew, double fuelConsumption, int capacity, String companyName) {
        super(idPlane, distance, numOfEngine, name, crew, fuelConsumption, capacity);
        setCompanyName(companyName);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
