package by.masliakov.airline.common;

import by.masliakov.airline.entity.Airline;
import by.masliakov.airline.entity.Plane;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mrstark on 8.6.15.
 */
public class SAXBuilder {

    final static Logger LOG = Logger.getLogger(SAXBuilder.class);

    private Airline airline;
    private PlaneHandler handler;
    private XMLReader reader;

    public SAXBuilder() {
        handler = new PlaneHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            airline = new Airline();
        } catch (SAXException e) {
            LOG.error(e);
        }
        LOG.info("SAXBuilder created");
    }


    public Airline getAirline() {
        return airline;
    }

    public void createSetPlanes(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            LOG.error(e);
        } catch (SAXException e) {
            LOG.error(e);
        }
        airline.setName(handler.getName());
        for (Plane plane : handler.getPlanes()) {
            airline.addPlane(plane);
        }
    }
}
