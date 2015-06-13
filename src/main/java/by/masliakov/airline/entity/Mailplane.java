package by.masliakov.airline.entity;

/**
 * Created by mrstark on 22.5.15.
 */
public class Mailplane extends Plane {

    private String company;

    public Mailplane() {}

    public Mailplane(int idPlane, int distance, int crew, double fuelConsumption, int capacity, String companyName) {
        super(idPlane, distance, crew, fuelConsumption, capacity);
        setCompanyName(companyName);
    }

    public String getCompanyName() {
        return company;
    }

    public void setCompanyName(String companyName) {
        if (companyName != null) {
            this.company = companyName;
        }
    }

    public String toString() {
        return super.toString() + " " + getCompanyName();
    }
}
