package ProyectNemo.directions;

import ProyectNemo.Position;

public class South extends Position {

    public void goFoward() {
        yCoord -= 1;
    }
    public West turnRight() {
        return new West();
    }
    public East turnLeft() {
        return new East();
    }
}
