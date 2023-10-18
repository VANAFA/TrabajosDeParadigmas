package ProyectNemo;

import java.util.ArrayList;

abstract public class Action {
    
    public Boolean canHandle( char command ) {
        return false;
    }
    
    abstract public Direction run( ArrayList<Integer> coords, Direction direction );
}

class Forward extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'f';
    } // TODO: ver si esto es necesario

    public Direction run( ArrayList<Integer> coords, Direction direction ) {
        coords = direction.goForward(coords);
        return direction;
    }
}

class Left extends Action {

    public Boolean canHandle( char command ) {
        return command == 'l';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction ) {
        return direction.turnLeft();
    }
}

class Right extends Action {

    public Boolean canHandle( char command ) {
        return command == 'r';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction ) {
        return direction.turnRight();
    }
}

class Down extends Action {
    
    public Boolean canHandle( char command ) {
        return command == 'd';
    }

    public Direction run( ArrayList<Integer> coords, Direction direction ) {
        coords.set( 2, coords.get( 2 ) + 1 );
        return direction;
    }
}

class Up extends Action {

    public Boolean canHandle( char command ) {
        return command == 'u';
    }
    
    public Direction run( ArrayList<Integer> coords, Direction direction ) {
        coords.set(2, Math.max(coords.get(2) - 1, 0)); // verificar si se puede usar math.max
        return direction;
    }
}

class DropCapsule extends Action {

        public Boolean canHandle( char command ) {
            return command == 'c';
        }
        
        public Direction run( ArrayList<Integer> coords, Direction direction ) {
            return direction;
        }
}