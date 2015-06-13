package by.masliakov.airline.common;


import by.masliakov.airline.entity.Plane;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import java.util.ArrayList;

/**
 * Created by mrstark on 13.6.15.
 */
public class StAXBuilder {

    final static Logger LOG = Logger.getLogger(StAXBuilder.class);

    private XMLInputFactory xmlInputFactory;
    private ArrayList<Plane> planes;

    public StAXBuilder() {
        xmlInputFactory = XMLInputFactory.newInstance();
        planes = new ArrayList<Plane>();
    }
}
