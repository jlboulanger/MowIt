package mowit;

import java.awt.Point;

import mowit.pojo.Grid;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void testcontains() {
        Grid g = new Grid(5, 5);
        assertFalse(g.contains(new Point(-1, -1)));
        assertFalse(g.contains(new Point(0, 6)));
        assertFalse(g.contains(new Point(6, 0)));
        assertFalse(g.contains(new Point(6, 6)));
        assertTrue(g.contains(new Point(5, 5)));
        assertTrue(g.contains(new Point(4, 0)));
        assertTrue(g.contains(new Point(0, 4)));
        assertTrue(g.contains(new Point(0, 0)));
    }
}
