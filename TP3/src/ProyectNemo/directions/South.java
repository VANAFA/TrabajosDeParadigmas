package ProyectNemo.directions;

import ProyectNemo.Direction;
import java.util.List;

public class South extends Direction {

    public List<Integer> goForward( List<Integer> position ) {
        position.set(1, position.get(1) - 1);
        return position;
    }

    public Direction turnRight() {
        return new West();
    }
    
    public Direction turnLeft() {
        return new East();
    }
}
