package by.masliakov.airline.main;

import by.masliakov.airline.common.DOMBuilder;
import by.masliakov.airline.common.FileConnection;
import by.masliakov.airline.entity.Airline;
import by.masliakov.airline.exception.TechnicalException;
import by.masliakov.airline.exception.WrongConfigurationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by mrstark on 21.5.15.
 */
public class Main {

    final static Logger LOG = Logger.getLogger(Main.class);
    static {
        new DOMConfigurator().doConfigure("src/main/resources/log4j2.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args)  {
        FileConnection fileConnection = new FileConnection("src/main/resources/planelist.xml");
        Document document = null;
        try {
            document = fileConnection.connect();

            Airline airline1= (new DOMBuilder()).createAirline(document);
            for (int i = 0; i < airline1.getNumberOfPlanes(); i++) {
                LOG.info(airline1.getPlainById(i).getIdPlane() + " " + airline1.getPlainById(i).getMaxDistance());
            }
        } catch (TechnicalException e) {
            LOG.error(e);
        } catch (WrongConfigurationException e) {
            LOG.error(e);
        }
    }
}
