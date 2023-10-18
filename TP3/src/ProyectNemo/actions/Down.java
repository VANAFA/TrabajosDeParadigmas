package ProyectNemo.actions;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Down extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'd';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction, Integer depth, Integer depthLimit, Boolean capsuleWasDropped ) {
        depth += 1;
        return direction;
    }
}
