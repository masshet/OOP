package by.masliakov.airline.entity;

import java.util.Comparator;

/**
 * Created by mrstark on 21.5.15.
 */
abstract public class Plane {

    private int maxDistance;
    private int idPlane;
    private int crew;
    private double fuelConsumption;
    private int capacity;

    public Plane(int idPlane, int distance, int crew, double fuelConsumption, int capacity) {
        setIdPlane(idPlane);
        setMaxDistance(distance);
        setCrew(crew);
        setFuelConsumption(fuelConsumption);
        setCapacity(capacity);
    }

    public Plane() {}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        if (idPlane > 0) {
            this.idPlane = idPlane;
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int distance) {
        if (distance > 0) {
            this.maxDistance = distance;
        }
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        if (crew > 0)
        this.crew = crew;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption > 0) {
            this.fuelConsumption = fuelConsumption;
        }
    }

    public String toString() {
        return getIdPlane() + " " + " " + getMaxDistance() + " " + " "
                + " " + getCapacity() + " " + getCrew() + " " + getFuelConsumption();
    }
}
