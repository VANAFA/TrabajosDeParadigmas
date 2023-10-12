package ProyectNemo.orders;

import java.util.List;
import ProyectNemo.Command;
import ProyectNemo.Direction;

public class Down extends Command {
    
    public void go( List<Integer> coords, Direction direction ) {
        coords.set(2, Math.min(coords.get(2) + 1, 4));
    }
}
