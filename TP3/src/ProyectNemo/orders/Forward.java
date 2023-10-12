package ProyectNemo.orders;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Forward extends Action {
    
    public void go( ArrayList<Integer> coords, Direction direction ) {
        coords = direction.goForward(coords);
    }
}
