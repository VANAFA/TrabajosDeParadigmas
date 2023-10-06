package ProyectNemo.directions;

import ProyectNemo.Position;

public class West extends Position {

    public void goFoward() {
        xCoord -= 1;
    }
    public North turnRight() {
        return new North();
    }
    public South turnLeft() {
        return new South();
    }
}