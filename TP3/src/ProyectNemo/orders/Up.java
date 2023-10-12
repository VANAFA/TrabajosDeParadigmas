package ProyectNemo.orders;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Up extends Action {
    
    public void go( ArrayList<Integer> coords, Direction direction ) {
        coords.set(2, Math.max(coords.get(2) - 1, 0));
    }
}
