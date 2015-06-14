package by.masliakov.airline.common;


import by.masliakov.airline.entity.*;
import org.apache.log4j.Logger;

import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mrstark on 13.6.15.
 */
public class StAXBuilder {

    final static Logger LOG = Logger.getLogger(StAXBuilder.class);

    private XMLInputFactory xmlInputFactory;
    private Airline airline;

    public StAXBuilder() {
        xmlInputFactory = XMLInputFactory.newInstance();
        airline = new Airline();
        LOG.info("StAXBuilder created");
    }

    public Airline getAirline() {
        return airline;
    }

    public void buildAirline(String fileName) {
        FileInputStream fileInputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            fileInputStream = new FileInputStream(new File(fileName));
            reader = xmlInputFactory.createXMLStreamReader(fileInputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (PlaneEnum.valueOf(name.toUpperCase()) == PlaneEnum.PLANE) {
                        Plane plane = buildPlane(reader);
                        airline.addPlane(plane);
                    } else if (PlaneEnum.valueOf(name.toUpperCase()) == PlaneEnum.AIRLINE) {
                        airline.setName(reader.getAttributeValue(0));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOG.error(e);
        } catch (XMLStreamException e) {
            LOG.error(e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                LOG.error(e);
            }
        }
    }

    private Plane buildPlane(XMLStreamReader reader) throws XMLStreamException {
        Plane plane = newPlane(Integer.parseInt(reader.getAttributeValue(null, PlaneEnum.TYPE.getValue())));
        plane.setIdPlane(Integer.parseInt(reader.getAttributeValue(null, PlaneEnum.ID.getValue())));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PlaneEnum.valueOf(name.toUpperCase())) {
                        case DISTANCE:
                            plane.setMaxDistance(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CREW:
                            plane.setCrew(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CAPACITY:
                            plane.setCapacity(Integer.parseInt(getXMLText(reader)));
                            break;
                        case CARGO:
                            ((Carrier) plane).setTypeOfCargo(getXMLText(reader));
                            break;
                        case COMPANY:
                            ((Mailplane) plane).setCompanyName(getXMLText(reader));
                            break;
                        case FUEL:
                            plane.setFuelConsumption(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PASS:
                            ((Airliner) plane).setNumOfPass(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SPORT:
                            ((Sportplane) plane).setKindOfSport(getXMLText(reader));
                            break;
                        case DISCHARGE:
                            ((Fireplane) plane).setRateOfDischarge(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PlaneEnum.valueOf(name.toUpperCase()) == PlaneEnum.PLANE) {
                        return plane;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag Plan");
    }

    private Plane newPlane(int type) {
        switch (type) {
            case 1:
                return new Airliner();
            case 2:
                return new Carrier();
            case 3:
                return new Sportplane();
            case 4:
                return new Fireplane();
            case 5:
                return new Mailplane();
            default:
                throw new IllegalArgumentException("illegal mode");
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
