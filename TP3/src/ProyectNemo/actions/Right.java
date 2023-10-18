package ProyectNemo.actions;

import java.util.ArrayList;
import ProyectNemo.Action;
import ProyectNemo.Direction;

public class Right extends Action {

    public Boolean canHandle( char command ) {
        return command == 'r';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction, Integer depth, Integer depthLimit, Boolean capsuleWasDropped ) {
        return direction.turnRight();
    }
}
