package ProyectNemo.directions;

import ProyectNemo.*;

public class East extends Direction {
    
    public void goForward( Submarine sub ) {
        sub.position.set(0, sub.position.get(0) + 1);
    }

    public Direction turnRight() {
        return new South();
    }
    
    public Direction turnLeft() {
        return new North();
    }
}