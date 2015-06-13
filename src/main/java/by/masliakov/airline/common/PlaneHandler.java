package by.masliakov.airline.common;

import by.masliakov.airline.entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;

/**
 * Created by mrstark on 11.6.15.
 */
public class PlaneHandler extends DefaultHandler {

    final static Logger LOG = Logger.getLogger(PlaneHandler.class);

    private ArrayList<Plane> planes;
    private String name;
    private Plane plane;
    private PlaneEnum planeEnum;
    private EnumSet<PlaneEnum> withText;

    public PlaneHandler() {
        planes = new ArrayList<Plane>();
        name = new String();
        withText = EnumSet.range(PlaneEnum.DISTANCE, PlaneEnum.CAPACITY);
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(PlaneEnum.PLANE.getValue().toLowerCase().equals(localName)) {
            plane = createPlane(Integer.parseInt(attributes.getValue(1)));
            plane.setIdPlane(Integer.parseInt(attributes.getValue(0)));
        } else if(PlaneEnum.AIRLINE.getValue().toLowerCase().equals(localName)) {
            setName(attributes.getValue(0));
        } else
         {
            PlaneEnum temp = PlaneEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                planeEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (PlaneEnum.PLANE.getValue().toLowerCase().equals(localName)) {
            planes.add(plane);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (planeEnum != null) {
            switch (planeEnum) {
                case DISTANCE:
                    plane.setMaxDistance(Integer.parseInt(s));
                    break;
                case CREW:
                    plane.setCrew(Integer.parseInt(s));
                    break;
                case CAPACITY:
                    plane.setCapacity(Integer.parseInt(s));
                    break;
                case CARGO:
                    ((Carrier) plane).setTypeOfCargo(s);
                    break;
                case COMPANY:
                    ((Mailplane) plane).setCompanyName(s);
                    break;
                case FUEL:
                    plane.setFuelConsumption(Integer.parseInt(s));
                    break;
                case PASS:
                    ((Airliner) plane).setNumOfPass(Integer.parseInt(s));
                    break;
                case SPORT:
                    ((Sportplane) plane).setKindOfSport(s);
                    break;
                case DISCHARGE:
                    ((Fireplane) plane).setRateOfDischarge(Integer.parseInt(s));
                    break;
            }
            planeEnum = null;
        }
    }

    private Plane createPlane(int type) {
        switch (type) {
            case 1:
                withText.add(PlaneEnum.PASS);
                return new Airliner();
            case 2:
                withText.add(PlaneEnum.CARGO);
                return new Carrier();
            case 3:
                withText.add(PlaneEnum.SPORT);
                return new Sportplane();
            case 4:
                withText.add(PlaneEnum.DISCHARGE);
                return new Fireplane();
            case 5:
                withText.add(PlaneEnum.COMPANY);
                return new Mailplane();
            default:
                throw new IllegalArgumentException("illegal mode");
        }
    }
}
