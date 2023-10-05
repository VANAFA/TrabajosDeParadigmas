package NemoProyect;

import java.util.ArrayList;

abstract public class Position {
    protected int xCoord = 0;
    protected int yCoord = 0;
    
    public ArrayList<Integer> getCoords() {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        coords.add(xCoord);
        coords.add(yCoord);
        return coords;
    }

    public String getDirection() {
        return getClass().getSimpleName().toUpperCase();
    }

    abstract public Position turnRight();
    abstract public Position turnLeft();
    abstract public void go();
}