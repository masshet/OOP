package by.masliakov.airline.common;

import by.masliakov.airline.entity.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by mrstark on 9.6.15.
 */
public class DOMBuilder {

    final static Logger LOG = Logger.getLogger(DOMBuilder.class);

    private Airline airline;

    public Airline createAirline(Document document) {
        LOG.info("DOMBuilder start");
        Element root = document.getDocumentElement();
        airline = new Airline(root.getAttribute("name"));
        NodeList nodeList = root.getElementsByTagName("plane");
        for (int i = 0; i < nodeList.getLength(); i++) {
            airline.addPlane(createPlane((Element) nodeList.item(i)));
        }
        return airline;
    }

    public Plane createPlane(Element element) {
        int idPlane = Integer.parseInt(getAttributeTextContent(element, "id"));
        int type = Integer.parseInt(getAttributeTextContent(element, "type"));
        int distance = Integer.parseInt(getElementTextContent(element, "distance"));
        int crew = Integer.parseInt(getElementTextContent(element, "crew"));
        double fuelConsumption = Double.parseDouble(getElementTextContent(element, "fuel"));
        int capacity = Integer.parseInt(getElementTextContent(element, "capacity"));
        switch (type) {
            case 1:
                int pass = Integer.parseInt(getElementTextContent(element, "pass"));
                return new Airliner(idPlane, distance, crew, fuelConsumption, capacity, pass);
            case 2:
                String cargo = getElementTextContent(element, "cargo");
                return new Carrier(idPlane, distance, crew, fuelConsumption, capacity, cargo);
            case 3:
                String sport = getElementTextContent(element, "sport");
                return new Sportplane(idPlane, distance, crew, fuelConsumption, capacity, sport);
            case 4:
                int discharge = Integer.parseInt(getElementTextContent(element, "discharge"));
                return new Fireplane(idPlane, distance, crew, fuelConsumption, capacity, discharge);
            case 5:
                String company = getElementTextContent(element, "company");
                return new Mailplane(idPlane, distance, crew, fuelConsumption, capacity, company);
            default:
                throw new IllegalArgumentException("illegal mode");
        }
    }

    private static String getAttributeTextContent(Element element, String name) {
        return element.getAttributes().getNamedItem(name).getNodeValue();
    }

    private static String getElementTextContent(Element element, String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
