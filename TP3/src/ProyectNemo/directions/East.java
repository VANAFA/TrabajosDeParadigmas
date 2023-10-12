package ProyectNemo.directions;

import ProyectNemo.Direction;
import java.util.List;

public class East extends Direction {
    
    public List<Integer> goForward( List<Integer> position ) {
        position.set(0, position.get(0) + 1);
        return position;
    }

    public Direction turnRight() {
        return new South();
    }
    
    public Direction turnLeft() {
        return new North();
    }
}