package mowit;

import java.awt.Point;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import mowit.pojo.Grid;
import mowit.pojo.Mower;
import mowit.pojo.Orientation;
import mowit.service.Service;

public class ServiceTest {

    private Grid g;
    private Service srv = new Service();

    @Before
    public void setUp() {
        g = new Grid(5, 5);
    }

    @Test
    public void testXebia() {
        Mower m1 = new Mower(1, 2, "N");
        Mower m2 = new Mower(3, 3, "E");
        Point resultP1 = new Point(1, 3);
        Point resultP2 = new Point(5, 1);
        
        Mower result1 = srv.mow(g, m1, "GAGAGAGAA");//1 3 N
        Mower result2 = srv.mow(g, m2, "AADAADADDA");//5 1 E
        
        //check first result
        assertNotNull(result1);
        assertEquals(resultP1, result1.getPosition());
        assertEquals(Orientation.N, result1.getOrientation());
        //check second result
        assertNotNull(result2);
        assertEquals(resultP2, result2.getPosition());
        assertEquals(Orientation.E, result2.getOrientation());
    }

    @Test
    public void testMoveUp() {
        Mower m1 = new Mower(1, 1, "N");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'A');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.N, m1.getOrientation());
        assertEquals(new Point(1, 2), m1.getPosition());
        assertEquals(m1, g.getMower(m1.getId()));
    }

    @Test
    public void testMoveDown() {
        Mower m1 = new Mower(1, 1, "S");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'A');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.S, m1.getOrientation());
        assertEquals(new Point(1, 0), m1.getPosition());
        assertEquals(m1, g.getMower(m1.getId()));
    }

    @Test
    public void testMoveLeft() {
        Mower m1 = new Mower(1, 1, "W");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'A');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.W, m1.getOrientation());
        assertEquals(new Point(0, 1), m1.getPosition());
        assertEquals(m1, g.getMower(m1.getId()));
    }

    @Test
    public void testMoveRight() {
        Mower m1 = new Mower(1, 1, "E");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'A');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.E, m1.getOrientation());
        assertEquals(new Point(2, 1), m1.getPosition());
        assertEquals(m1, g.getMower(m1.getId()));
    }
    
    @Test
    public void testMoveOutside() {
        Mower m1 = new Mower(5, 5, "N");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'A');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.N, m1.getOrientation());
        assertEquals(new Point(5, 5), m1.getPosition());
        assertEquals(m1, g.getMower(m1.getId()));
    }

    @Test
    public void testFaceRight() {
        Mower m1 = new Mower(0, 0, "N");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'D');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.E, m1.getOrientation());
        srv.move(g, m1.getId(), 'D');
        assertEquals(Orientation.S, m1.getOrientation());
        srv.move(g, m1.getId(), 'D');
        assertEquals(Orientation.W, m1.getOrientation());
        srv.move(g, m1.getId(), 'D');
        assertEquals(Orientation.N, m1.getOrientation());
        assertEquals(new Point(0, 0), m1.getPosition());
    }

    @Test
    public void testFaceLeft() {
        Mower m1 = new Mower(0, 0, "N");
        g.addMower(m1);
        srv.move(g, m1.getId(), 'G');
        assertNotNull(g.getMower(m1.getId()));
        assertEquals(Orientation.W, m1.getOrientation());
        srv.move(g, m1.getId(), 'G');
        assertEquals(Orientation.S, m1.getOrientation());
        srv.move(g, m1.getId(), 'G');
        assertEquals(Orientation.E, m1.getOrientation());
        srv.move(g, m1.getId(), 'G');
        assertEquals(Orientation.N, m1.getOrientation());
        assertEquals(new Point(0, 0), m1.getPosition());
    }
}
