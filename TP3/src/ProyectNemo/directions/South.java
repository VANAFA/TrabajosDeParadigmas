package ProyectNemo.directions;

import ProyectNemo.Direction;

import java.util.ArrayList;

public class South extends Direction {

    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(1, coords.get(1) - 1);
        return coords;
    }

    public Direction turnRight() {
        return new West();
    }
    
    public Direction turnLeft() {
        return new East();
    }
}
