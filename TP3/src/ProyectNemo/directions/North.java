package ProyectNemo.directions;

import ProyectNemo.Position;

public class North extends Position {
    
    public void goFoward() {
        yCoord += 1;
    }
    public East turnRight() {
        return new East();
    }
    public West turnLeft() {
        return new West();
    }
}
