package ProyectNemo.actions;

import ProyectNemo.*;

public class Down extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'd';
    }

    public void run( Submarine sub ) {
        sub.depthState.goDown();
    }
}