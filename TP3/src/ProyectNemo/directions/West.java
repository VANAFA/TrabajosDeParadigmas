package ProyectNemo.directions;

import ProyectNemo.Position;
import java.util.List;

public class West extends Position {

    public List<Integer> goFoward( List<Integer> position ) {
        position.set(0, position.get(0) - 1);
        return position;
    }
    public Position turnRight() {
        return new North();
    }
    public Position turnLeft() {
        return new South();
    }
}