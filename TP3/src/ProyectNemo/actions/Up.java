package ProyectNemo.actions;

import ProyectNemo.*;

public class Up extends Action {

    public Boolean canHandle( char command ) {
        return command == 'u';
    }
    
    public void run( Submarine sub ) {
        sub.depthState.goUp();
    }
}