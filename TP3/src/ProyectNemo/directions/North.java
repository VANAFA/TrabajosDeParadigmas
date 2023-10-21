package ProyectNemo.directions;

import ProyectNemo.*;

public class North extends Direction {
    
    public void goForward( Submarine sub ) {
        sub.position.set(1, sub.position.get(1) + 1);
    }

    public Direction turnRight() {
        return new East();
    }
    
    public Direction turnLeft() {
        return new West();
    }
}