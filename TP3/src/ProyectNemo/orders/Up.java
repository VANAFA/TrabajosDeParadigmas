package ProyectNemo.orders;

import java.util.List;
import ProyectNemo.Command;
import ProyectNemo.Direction;

public class Up extends Command {
    
    public void go( List<Integer> coords, Direction direction ) {
        coords.set(2, Math.max(coords.get(2) - 1, 0));
    }
}
