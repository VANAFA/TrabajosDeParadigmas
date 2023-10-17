package ProyectNemo.orders;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Right extends Action {

    public void go( ArrayList<Integer> coords, Direction direction ) {
        direction = direction.turnRight();
    }
}
