package mowit.pojo;

import java.awt.Point;
import java.io.Serializable;
import java.util.UUID;

public class Mower implements Serializable {

    private static final long serialVersionUID = 7397917769141098855L;

    private Point position;
    private Orientation orientation;
    private UUID id;

    /**
     * Constructor
     * @param originX x position
     * @param originY y position
     * @param orientation orientation: N,S,W,E . Assumed to be not null 
     */
    public Mower(int originX, int originY, String orientation) {
        this.position = new Point(originX, originY);
        this.orientation = Orientation.valueOf(orientation.toUpperCase());
        this.id = UUID.randomUUID();
    }

    public Mower(Point origin, Orientation orignO) {
        this.position = origin;
        this.orientation = orignO;
        this.id = UUID.randomUUID();
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mower other = (Mower) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (orientation != other.orientation)
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mow [position=" + position + ", orientation=" + orientation + ", id=" + id + "]";
    }

}
