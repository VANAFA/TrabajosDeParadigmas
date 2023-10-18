package ProyectNemo;

import java.util.ArrayList;

abstract public class Action {
    
    public Boolean canHandle( char command ) {
        return false;
    }
    
    abstract public Direction run( ArrayList<Integer> coords, Direction direction, Integer depth, Integer depthLimit, Boolean capsuleWasDropped );
}
