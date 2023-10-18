package ProyectNemo;

import java.util.ArrayList;

abstract public class Direction {

    abstract public Direction turnRight();
    abstract public Direction turnLeft();
    abstract public ArrayList<Integer> goForward( ArrayList<Integer> coords );
}

class North extends Direction {
    
    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(1, coords.get(1) + 1);
        return coords;
    }

    public Direction turnRight() {
        return new East();
    }
    
    public Direction turnLeft() {
        return new West();
    }
}

class South extends Direction {

    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(1, coords.get(1) - 1);
        return coords;
    }

    public Direction turnRight() {
        return new West();
    }
    
    public Direction turnLeft() {
        return new East();
    }
}

class East extends Direction {
    
    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(0, coords.get(0) + 1);
        return coords;
    }

    public Direction turnRight() {
        return new South();
    }
    
    public Direction turnLeft() {
        return new North();
    }
}
class West extends Direction {

    public ArrayList<Integer> goForward( ArrayList<Integer> coords ) {
        coords.set(0, coords.get(0) - 1);
        return coords;
    }

    public Direction turnRight() {
        return new North();
    }
    
    public Direction turnLeft() {
        return new South();
    }
}