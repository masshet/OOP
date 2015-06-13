package by.masliakov.airline.entity;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mrstark on 21.5.15.
 */
public class Airline {

    final static Logger LOG = Logger.getLogger(Airline.class);

    private String name;
    private ArrayList<Plane> planes;

    public Airline(String name) {
        planes = new ArrayList<Plane>();
        setName(name);
    }

    public Airline() {
        planes = new ArrayList<Plane>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public ArrayList<Plane> getPlanes() {
        return (ArrayList<Plane>) Collections.unmodifiableList(planes);
    }*/

    public int getNumberOfPlanes() {
        return planes.size();
    }

    public Plane getPlainById (int id) {
        return planes.get(id);
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public void sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return Integer.compare(o1.getMaxDistance(), o2.getMaxDistance());
            }
        });
    }

    public void printPlanes() {
        LOG.info(getName());
        for (int i = 0; i < getNumberOfPlanes(); i++) {
            LOG.info(getPlainById(i).toString());
        }
    }
}
