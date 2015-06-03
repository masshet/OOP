package by.masliakov.airline.entity;

/**
 * Created by mrstark on 21.5.15.
 */
public class Airliner extends Plane {

    private int numOfPass;

    public Airliner(int idPlane, int maxDistance, int numOfEngine, String name,
                    int crew, double fuelConsumption, int capacity, int numOfPass) {
        super(idPlane, maxDistance, numOfEngine, name, crew, fuelConsumption, capacity);
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
}
