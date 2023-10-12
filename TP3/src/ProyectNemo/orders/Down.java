package ProyectNemo.orders;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Down extends Action {
    
    public void go( ArrayList<Integer> coords, Direction direction ) {
        coords.set(2, Math.min(coords.get(2) + 1, 4));
    }
}
