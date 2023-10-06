package NemoProyect.directions;

import NemoProyect.Position;

public class East extends Position {
    
    public void goFoward() {
        xCoord += 1;
    }
    public South turnRight() {
        return new South();
    }
    public North turnLeft() {
        return new North();
    }
}