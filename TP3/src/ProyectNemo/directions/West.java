package ProyectNemo.directions;

import ProyectNemo.Direction;

import java.util.ArrayList;

public class West extends Direction {

    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(0, coords.get(0) - 1);
        return coords;
    }

    public Direction turnRight() {
        return new North();
    }
    
    public Direction turnLeft() {
        return new South();
    }
}