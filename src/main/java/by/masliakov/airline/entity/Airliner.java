package by.masliakov.airline.entity;

/**
 * Created by mrstark on 21.5.15.
 */
public class Airliner extends Plane {

    private int numOfPass;

    public Airliner(){}

    public Airliner(int idPlane, int maxDistance, int crew, double fuelConsumption, int capacity, int numOfPass) {
        super(idPlane, maxDistance, crew, fuelConsumption, capacity);
        setNumOfPass(numOfPass);
    }

    public int getNumOfPass() {
        return numOfPass;
    }

    public void setNumOfPass(int numOfPass) {
        if (numOfPass > 0) {
            this.numOfPass = numOfPass;
        }
    }

    public String toString() {
        return super.toString() + " " + getNumOfPass();
    }
}
