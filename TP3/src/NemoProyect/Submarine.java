package NemoProyect;

import java.util.ArrayList;

import NemoProyect.directions.North;

public class Submarine {
    private int depth = 0;
    private Position position = new North();
    
    public int getDepth() {
        return depth;
    }
    
    public ArrayList<Integer> getPosition() {
        return position.getCoords();
    }

    public String getDirection() {
        return position.getDirection();
    }

    public void go(String command) {
        ArrayList<Character> orders = new ArrayList<Character>(); 
        command.chars().forEach(c -> orders.add((char) c));

        for (Character c : orders) {
            if (c.equals('d')) {
                depth += 1;
            }
            if (c.equals('u')) {
                if (depth > 0) {
                    depth -=1;
                }
            }
            if (c.equals('r')) {
                position = position.turnRight();
            }
            if (c.equals('l')) {
                position = position.turnLeft();
            }
            if (c.equals('f')) {
                position.go();
            }
        }
    }
} // search for lookup method