package ProyectNemo.directions;

import ProyectNemo.Direction;

import java.util.ArrayList;

public class East extends Direction {
    
    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(0, coords.get(0) + 1);
        return coords;
    }

    public Direction turnRight() {
        return new South();
    }
    
    public Direction turnLeft() {
        return new North();
    }
}