package ProyectNemo.actions;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Forward extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'f';
    } // TODO: ver si esto es necesario

    public Direction run( ArrayList<Integer> coords, Direction direction, Integer depth, Integer depthLimit, Boolean capsuleWasDropped ) {
        coords = direction.goForward(coords);
        return direction;
    }
}
