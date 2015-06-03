package by.masliakov.airline.main;

import by.masliakov.airline.entity.Airline;
import by.masliakov.airline.hardcode.AirlineCreator;
import by.masliakov.airline.operation.AirplaneOperation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by mrstark on 21.5.15.
 */
public class Main {

    final static Logger LOG = Logger.getLogger(Main.class);
    static {
        new DOMConfigurator().doConfigure("src/main/log4j2.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        Airline airline = new Airline();
        AirlineCreator airlineCreator = new AirlineCreator();
        airlineCreator.createAirline(airline);
        LOG.info("Total capacity: " + AirplaneOperation.countTotalCapacity(airline));
        LOG.info("total number of passenger: " + AirplaneOperation.countTotalNumberOfPassangers(airline));
        airline.sortByMaxDistance();
    }
}
