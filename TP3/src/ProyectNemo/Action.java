package ProyectNemo;

import java.util.ArrayList; // TODO:cada clase en un archivo distinto

abstract public class Action {
    abstract public Action canHandle( char command );
    abstract public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState );
}

class Forward extends Action {
    
    public Action canHandle( char command ) { // TODO: tratar de cambiar el canHandle
        super('f');
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

class commandNotAccepted extends Action {
    
    public Boolean canHandle( char command ) {
        return true;
    }
    
    public Direction run( ArrayList<Integer> coords, Direction direction, DepthState depthState ) {
        throw new RuntimeException("Command not available");
    }
}