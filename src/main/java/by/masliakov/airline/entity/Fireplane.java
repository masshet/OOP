package by.masliakov.airline.entity;

/**
 * Created by mrstark on 22.5.15.
 */
public class Fireplane extends Plane {

    private double rateOfDischarge;

    public Fireplane() {}

    public Fireplane(int idPlane, int distance, int crew, double fuelConsumption, int capacity, double rateOfDischarge) {
        super(idPlane, distance, crew, fuelConsumption, capacity);
        setRateOfDischarge(rateOfDischarge);
    }

    public double getRateOfDischarge() {
        return rateOfDischarge;
    }

    public void setRateOfDischarge(double rateOfDischarge) {
        if (rateOfDischarge > 0) {
            this.rateOfDischarge = rateOfDischarge;
        }
    }

    public String toString() {
        return super.toString() + " " + getRateOfDischarge();
    }
}
