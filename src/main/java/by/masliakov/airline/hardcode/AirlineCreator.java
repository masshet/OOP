package by.masliakov.airline.hardcode;

import by.masliakov.airline.entity.*;
import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by mrstark on 26.5.15.
 */
public class AirlineCreator {

    final static Logger LOG = Logger.getLogger(AirlineCreator.class);

    public void createAirline(Airline airline) {
        for (int i = 0; i < 10; i++) {
            airline.addPlane(createPlane(Constant.idPlane[i], Constant.maxDistance[i],
                    Constant.crew[i], Constant.fuelConsumption[i], Constant.capasity[i], Constant.type[i]));
        }
    }

    public Plane createPlane(int idPlane, int distance, int crew, double fuelConsumption, int capacity, int type) {
        switch (type) {
            case 1:
                int numOfPass = Constant.numOfPass[new Random().nextInt(3)];
                return new Airliner(idPlane, distance, crew, fuelConsumption, capacity, numOfPass);
            case 2:
                String typeOfCargo = Constant.typeOfCargo[new Random().nextInt(3)];
                return new Carrier(idPlane, distance, crew, fuelConsumption, capacity, typeOfCargo);
            case 3:
                return new Sportplane(idPlane, distance, crew, fuelConsumption, capacity, Constant.typeOfSport);
            case 4:
                double rateOfDischarge = Constant.rateOfDischarge[new Random().nextInt(2)];
                return new Fireplane(idPlane, distance, crew, fuelConsumption, capacity, rateOfDischarge);
            case 5:
                return new Mailplane(idPlane, distance, crew, fuelConsumption, capacity, Constant.nameOfCompany);
            default:
                throw new IllegalArgumentException("illegal mode");
        }
    }
}
