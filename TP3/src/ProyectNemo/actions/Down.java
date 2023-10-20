package ProyectNemo.actions;

import ProyectNemo.Action;
import ProyectNemo.Submarine;

public class Down extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'd';
    }

    public void run( Submarine sub ) {
        sub.depthState.goDown();
    }
}