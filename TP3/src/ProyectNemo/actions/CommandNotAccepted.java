package ProyectNemo.actions;

import ProyectNemo.*;

public class CommandNotAccepted extends Action {
    
    public Boolean canHandle( char command ) {
        return true;
    }
    
    public void run( Submarine sub ) {
        throw new RuntimeException("Command not available");
    }
}