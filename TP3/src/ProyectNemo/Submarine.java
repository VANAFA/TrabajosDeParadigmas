package ProyectNemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ProyectNemo.directions.North;

public class Submarine {
    private Position position = new North();
    
    public int getDepth() {
        return position.getDepth();
    }
    
    public ArrayList<Integer> getPosition() {
        return position.getCoords();
    }

    public String getDirection() {
        return position.getDirection();
    }

    public void go(String command) {

        Map<Character, Runnable> actions = new HashMap<>();
        actions.put('d', () -> position.goDown());
        actions.put('u', () -> position.goUp());
        actions.put('r', () -> position = position.turnRight()); // TODO: change the direction when it turns
        actions.put('l', () -> position = position.turnLeft()); // TODO: change the direction when it turns
        actions.put('f', () -> position.goFoward());

        command.chars().forEach(c -> actions.get((char) c).run());    
    }
}