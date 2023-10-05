package NemoProyect.directions;

import NemoProyect.Position;

public class South extends Position {

    public void go() {
        yCoord -= 1;
    }
    public West turnRight() {
        return new West();
    }
    public East turnLeft() {
        return new East();
    }
}
