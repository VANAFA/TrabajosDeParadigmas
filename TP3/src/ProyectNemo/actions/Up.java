package ProyectNemo.actions;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Up extends Action {

    public Boolean canHandle( char command ) {
        return command == 'u';
    }
    
    public Direction run( ArrayList<Integer> coords, Direction direction, Integer depth, Integer depthLimit, Boolean capsuleWasDropped ) {
        coords.set(2, Math.max(coords.get(2) - 1, 0));
        return direction;
    }
}
