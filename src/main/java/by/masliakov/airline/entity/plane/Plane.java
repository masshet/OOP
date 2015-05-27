package by.masliakov.airline.entity.plane;

import java.util.Comparator;

/**
 * Created by mrstark on 21.5.15.
 */
abstract public class Plane {

    private int maxDistance;
    private int numOfEngine;
    private int idPlane;
    private String brand;
    private int crew;
    private double fuelConsumption;
    private int capacity;

    public Plane(int idPlane, int distance, int numOfEngine, String brand, int crew, double fuelConsumption, int capacity) {
        setIdPlane(idPlane);
        setMaxDistance(distance);
        setNumOfEngine(numOfEngine);
        setBrand(brand);
        setCrew(crew);
        setFuelConsumption(fuelConsumption);
        setCapacity(capacity);
    }

    public Plane() {}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int distance) {
        this.maxDistance = distance;
    }

    public int getNumOfEngine() {
        return numOfEngine;
    }

    public void setNumOfEngine(int numOfEngine) {
        this.numOfEngine = numOfEngine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String toString() {
        return getIdPlane() + " " + getBrand() + " " + getMaxDistance() + " " + getNumOfEngine() + " "
                + " " + getCapacity() + " " + getCrew() + " " + getFuelConsumption();
    }
}
