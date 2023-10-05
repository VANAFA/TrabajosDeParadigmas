package NemoProyect.directions;

import NemoProyect.Position;

public class West extends Position {

    public void go() {
        xCoord -= 1;
    }
    public North turnRight() {
        return new North();
    }
    public South turnLeft() {
        return new South();
    }
}