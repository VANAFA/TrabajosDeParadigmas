package ProyectNemo.actions;

import ProyectNemo.*;

public class Left extends Action {

    public Boolean canHandle( char command ) {
        return command == 'l';
    }

    public void run( Submarine sub ) {
        sub.direction = sub.direction.turnLeft();
    }
}