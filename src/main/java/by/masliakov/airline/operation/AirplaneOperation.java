package by.masliakov.airline.operation;

import by.masliakov.airline.entity.Airline;
import by.masliakov.airline.entity.plane.Airliner;
import by.masliakov.airline.entity.plane.Plane;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mrstark on 27.5.15.
 */
public class AirplaneOperation {

    public double countTotalCapacity(Airline airline) {
        double capacity = 0;
        for (int i = 0; i < airline.getNumberOfPlanes(); i++) {
            capacity += airline.getPlainById(i).getCapacity();
        }
        return capacity;
    }

    public int countTotalNumberOfPassangers(Airline airline) {
        int totalNumOfPass = 0;
        for (int i = 0; i < airline.getNumberOfPlanes(); i++) {
            if (airline.getPlainById(i) instanceof Airliner) {
                totalNumOfPass += ((Airliner) airline.getPlainById(i)).getNumOfPass();
            }
//            totalNumOfPass += airline.getPlainById(i).getCrew();
        }
        return totalNumOfPass;
    }
}
