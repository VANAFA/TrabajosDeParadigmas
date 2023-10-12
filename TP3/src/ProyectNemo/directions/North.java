package ProyectNemo.directions;

import ProyectNemo.Direction;
import java.util.ArrayList;

public class North extends Direction {
    
    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(1, coords.get(1) + 1);
        return coords;
    }

    public Direction turnRight() {
        return new East();
    }
    
    public Direction turnLeft() {
        return new West();
    }
}
