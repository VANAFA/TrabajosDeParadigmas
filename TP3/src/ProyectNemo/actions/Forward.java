package ProyectNemo.actions;

import ProyectNemo.*;

public class Forward extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'f';
    }

    public void run( Submarine sub ) {
        sub.direction.goForward( sub );
    }
}