package ProyectNemo.actions;

import ProyectNemo.Action;
import ProyectNemo.Submarine;

public class Up extends Action {

    public Boolean canHandle( char command ) {
        return command == 'u';
    }
    
    public void run( Submarine sub ) {
        sub.depthState.goUp();
    }
}