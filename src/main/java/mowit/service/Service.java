package mowit.service;

import java.awt.Point;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import mowit.pojo.Grid;
import mowit.pojo.Mower;

public class Service {


    /**
     * Add the mower to the grid and start mowing according to the instruction lists 
     * @param g the grid to mow
     * @param m the mower, with starting position set
     * @param instructions the list of instructions. Must be a string following the regexpr [AGD]*  Any other instructions
     * will be ignored
     * @return the mower,update to its last position
     */
    public Mower mow(Grid g, Mower m, String instructions) {
        //first, add mower to the grid
        g.addMower(m);
        //for each instruction, move the mower on the grid
        instructions.chars().filter(a -> (a == 'A') || (a == 'G') || (a == 'D')).forEach(a -> move(g, m.getId(), a));
        return g.getMower(m);
    }

    public void move(Grid g, UUID id, int action) {
        Mower m = g.getMower(id);
        switch (action) {
        case 'A': {
            Point newPosition = add(m.getPosition(), m.getOrientation().forward());
            if (g.contains(newPosition)) {
                m.getPosition().move(newPosition.x, newPosition.y);
            }
            break;
        }
        case 'G': {
           m.setOrientation(m.getOrientation().left());
            break;
        }
        case 'D': {
            m.setOrientation(m.getOrientation().right()); 
            break;
        }

        default:
            throw new IllegalArgumentException();
        }
    }

    private Point add(Point a, Point b) {
        return new Point(a.x + b.x, a.y + b.y);
    }
}
