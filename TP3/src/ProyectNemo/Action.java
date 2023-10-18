package ProyectNemo;

import java.util.ArrayList;

abstract public class Action {
    
    public Boolean canHandle( char command ) {
        return false; // TODO: here shoul be thrown the error
    }
    
    abstract public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState );
}

class Forward extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'f'; // TODO: preguntar si este == puede estar
    }

    public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
        coords = direction.goForward(coords);
        return direction;
    }
}

class Left extends Action {

    public Boolean canHandle( char command ) {
        return command == 'l';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
        return direction.turnLeft();
    }
}

class Right extends Action {

    public Boolean canHandle( char command ) {
        return command == 'r';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
        return direction.turnRight();
    }
}

class Down extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'd';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
        depthState.goDown();
        return direction;
    }
}

class Up extends Action {

    public Boolean canHandle( char command ) {
        return command == 'u';
    }
    
    public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
        depthState.goUp();
        return direction;
    }
}

class DropCapsule extends Action {

        public Boolean canHandle( char command ) {
            return command == 'm';
        }
        
        public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
            depthState.dropCapsule();
            return direction;
        }
}