package ProyectNemo.orders;

import java.util.List;
import ProyectNemo.Command;
import ProyectNemo.Direction;

public class Forward extends Command {
    
    public void go( List<Integer> coords, Direction direction ) {
        coords = direction.goForward(coords);
    }
}
