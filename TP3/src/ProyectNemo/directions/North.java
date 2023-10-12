package ProyectNemo.directions;

import ProyectNemo.Direction;
import java.util.List;

public class North extends Direction {
    
    public List<Integer> goForward( List<Integer> position ) {
        position.set(1, position.get(1) + 1);
        return position;
    }

    public Direction turnRight() {
        return new East();
    }
    
    public Direction turnLeft() {
        return new West();
    }
}
