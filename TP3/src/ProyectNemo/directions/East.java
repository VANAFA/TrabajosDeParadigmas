package ProyectNemo.directions;

import ProyectNemo.Position;
import java.util.List;

public class East extends Position {
    
    public List<Integer> goForward( List<Integer> position ) {
        position.set(0, position.get(0) + 1);
        return position;
    }

    public Position turnRight() {
        return new South();
    }
    
    public Position turnLeft() {
        return new North();
    }
}