package ProyectNemo.actions;

import ProyectNemo.Action;
import ProyectNemo.Submarine;

public class DropCapsule extends Action {

    public Boolean canHandle( char command ) {
        return command == 'm';
    }
    
    public void run( Submarine sub ) {
        sub.depthState.dropCapsule();
    }
}