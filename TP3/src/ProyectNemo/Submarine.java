package ProyectNemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ProyectNemo.directions.Direction;

public class Submarine {
    private Direction position;
    
    public Submarine() {
        this.position = new North();
    }
    
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
        for (char c : command.toCharArray()) {
           if (c == 'd') {
               position.goDown();
           } else if (c == 'u') {
               position.goUp();
           } else if (c == 'r') {
               position = position.turnRight();
           } else if (c == 'l') {
               position = position.turnLeft();
           } else if (c == 'f') {
               position.goFoward();
           }
        }

        // Map<Character, Runnable> actions = new HashMap<>();
        // actions.put('d', () -> position.goDown());
        // actions.put('u', () -> position.goUp());
        // actions.put('r', () -> position = position.turnRight());
        // actions.put('l', () -> position = position.turnLeft());
        // actions.put('f', () -> position.goFoward());
        
        // ArrayList<Character> orders = new ArrayList<Character>(); 
        // command.chars().forEach(c -> orders.add((char) c));

        // for (Character c : orders) {
        //     Runnable action = actions.get(c);
        //     if (action != null) {
        //         action.run();
        //     }
        // }
    }
}
