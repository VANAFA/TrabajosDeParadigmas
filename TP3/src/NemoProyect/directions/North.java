package NemoProyect.directions;

import NemoProyect.Position;

public class North extends Position {
    
    public void go() {
        yCoord += 1;
    }
    public East turnRight() {
        return new East();
    }
    public West turnLeft() {
        return new West();
    }
}
