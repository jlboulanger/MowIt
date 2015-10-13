package mowit.pojo;

import java.awt.Point;

public enum Orientation {

    N, E, S, W;

    private static final Point UP = new Point(0, 1);
    private static final Point DOWN = new Point(0, -1);
    private static final Point LEFT = new Point(-1, 0);
    private static final Point RIGHT = new Point(1, 0);

    public Orientation right() {
        switch (this) {
        case N: return E;
        case E: return S;
        case S: return W;
        case W: return N;
        default:
            throw new IllegalStateException();
        }
    }

    public Orientation left() {
        switch (this) {
        case N: return W;
        case E: return N;
        case S: return E;
        case W: return S;
        default:
            throw new IllegalStateException();
        }
    }

    /**
     * Return the (x,y) increaseof a forward action, depending of the orientation
     * @return
     */
    public Point forward() {
        switch (this) {
        case N: return UP;
        case E: return RIGHT;
        case S: return DOWN;
        case W: return LEFT;
        default:
            throw new IllegalStateException();
        }
    }
}
