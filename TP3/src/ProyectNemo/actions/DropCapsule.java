package ProyectNemo.actions;

import ProyectNemo.*;

public class DropCapsule extends Action {

    public Boolean canHandle( char command ) {
        return command == 'm';
    }
    
    public void run( Submarine sub ) {
        sub.depthState.dropCapsule();
    }
}