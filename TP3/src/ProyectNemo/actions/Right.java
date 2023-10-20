package ProyectNemo.actions;

import ProyectNemo.Action;
import ProyectNemo.Submarine;

public class Right extends Action {

    public Boolean canHandle( char command ) {
        return command == 'r';
    }

    public void run( Submarine sub ) {
        sub.direction = sub.direction.turnRight();
    }
}
