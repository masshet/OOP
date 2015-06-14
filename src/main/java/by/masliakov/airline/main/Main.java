package by.masliakov.airline.main;

import by.masliakov.airline.common.DOMBuilder;
import by.masliakov.airline.common.FileConnection;
import by.masliakov.airline.common.SAXBuilder;
import by.masliakov.airline.common.StAXBuilder;
import by.masliakov.airline.entity.Airline;
import by.masliakov.airline.exception.TechnicalException;
import by.masliakov.airline.exception.WrongConfigurationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mrstark on 21.5.15.
 */
public class Main {

    final static String FILE_NAME = "src/main/resources/planelist.xml";
    final static Logger LOG = Logger.getLogger(Main.class);
    static {
        new DOMConfigurator().doConfigure("src/main/resources/log4j2.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args)  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose parser (1.DOM/2.SAX/3.StAX): ");
        try {
            String s = bufferedReader.readLine();
            switch (Integer.parseInt(s)) {
                case 1:
                    DOMBuilder domBuilder = new DOMBuilder();
                    Airline airline1= domBuilder.createAirline(FILE_NAME);
                    airline1.printPlanes();
                    break;
                case 2:
                    SAXBuilder saxBuilder = new SAXBuilder();
                    saxBuilder.createSetPlanes(FILE_NAME);
                    Airline airline2 = saxBuilder.getAirline();
                    airline2.printPlanes();
                    break;
                case 3:
                    StAXBuilder stAXBuilder = new StAXBuilder();
                    stAXBuilder.buildAirline(FILE_NAME);
                    Airline airline3 = stAXBuilder.getAirline();
                    airline3.printPlanes();
                    break;
                default:
                    LOG.error("Wrong input data!");
            }
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
