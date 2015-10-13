package mowit.pojo;

import java.awt.Point;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Grid implements Serializable {
    private static final long serialVersionUID = 3917347629277382068L;

    private static final Point ORIGIN = new Point(0,0);
    private final Point upperRight;
    private Map<UUID, Mower> mowers = new HashMap<UUID, Mower>(10);

    public Grid(int upperRightX, int upperRightY) {
        this.upperRight = new Point(upperRightX, upperRightY);
    }
    
    /**
     * Build a grid
     * @param p (x,y) of the upperRIght corner
     */
    public Grid(Point p) {
        this.upperRight = p;
    }

    /**
     * Check if the grid contains the point in parameter
     * @param p a non null point
     * @return true if the point is above or equals (0,0) and below or equals the upperRight corner
     */
    public boolean contains(Point p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return !(ORIGIN.getX() > p.getX() || ORIGIN.getY() > p.getY() || upperRight.getX() < p.getX()
                        || upperRight.getY() < p.getY());
    }

    /**
     * Add (or replace if exists) a mower in the grid's mowers list. If the mower starting position is not on the grid, 
     * will throw an IllegalArgumentException
     * @param m
     */
    public void addMower(Mower m) {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        if (contains(m.getPosition())) {
            mowers.put(m.getId(), m);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Mower getMower(Mower m) {
        if (m == null) {
            throw new IllegalArgumentException();
        }
        return mowers.get(m.getId());
    }

    public Mower getMower(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return mowers.get(id);
    }
}
