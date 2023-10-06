package ProyectNemo;

import java.util.ArrayList;

abstract public class Position {
    protected int xCoord = 0;
    protected int yCoord = 0;
    protected int depth = 0;
    
    public ArrayList<Integer> getCoords() {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        coords.add(xCoord);
        coords.add(yCoord);
        coords.add(depth);
        return coords;
    }

    public int getDepth() { //TODO: sacar este metodo
        return depth;
    }

    public int goDown() { //TODO: sacar este metodo
        return depth += 1;
    }

    public int goUp() { //TODO: sacar este metodo
        if (depth > 0) {
            return depth -= 1;
        }
        return depth;
    }

    public String getDirection() {
        return getClass().getSimpleName().toUpperCase();
    }

    abstract public Position turnRight();
    abstract public Position turnLeft();
    abstract public void goFoward();
}