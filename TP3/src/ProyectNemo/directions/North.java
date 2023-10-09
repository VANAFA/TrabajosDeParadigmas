package ProyectNemo.directions;

import ProyectNemo.Position;
import java.util.List;

public class North extends Position {
    
    public List<Integer> goFoward( List<Integer> position ) {
        position.set(1, position.get(1) + 1);
        return position;
    }
    public Position turnRight() {
        return new East();
    }
    public Position turnLeft() {
        return new West();
    }
}
