package ProyectNemo;

import java.util.ArrayList; // preferably use list
import java.util.List;

import ProyectNemo.directions.North;

public class Submarine {
    private Position position = new North();
    private Boolean capsuleWasDropped = false;
    private final static int depthLimit = 3; // this var is temp
    private boolean alive = true;
    private List<Integer> coords = new ArrayList<Integer>() {{
        add( 0 );
        add( 0 );
        add( 0 );
    }};
    
    public Boolean isAlive() {
        return alive;
    }

    public List<Integer> getPosition() {
        return coords;
    }
    
    public int getDepth() {
        return coords.get(2);
    }

    public String getDirection() {
        return position.getClass().getSimpleName();
    }

    public Boolean hasCapsule() {
        return !capsuleWasDropped;
    }

    public void go( String command ) {

        Runnable[] actions = new Runnable[128];
        actions['d'] = () -> coords.set(2, coords.get(2) + 1);
        actions['u'] = () -> { 
            if (coords.get(2) > 0) {
                coords.set(2, coords.get(2) - 1);
            }
        };
        actions['r'] = () -> position = position.turnRight();
        actions['l'] = () -> position = position.turnLeft();
        actions['f'] = () -> coords = position.goForward(coords);
        actions['m'] = () -> {
            if (coords.get(2) > depthLimit) {
                alive = false;
            }
            capsuleWasDropped = true;
        };

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (actions[c] != null && alive) {
                actions[c].run();
            }
        }
    }
}