package ProyectNemo;

import java.util.ArrayList; // preferably use list
import java.util.List;

import ProyectNemo.directions.North;

public class Submarine {
    private Position position = new North();
    private Boolean capsuleWasDropped = false;
    private boolean alive = true;
    private List<Integer> coords = new ArrayList<Integer>() {{
        add( 0 );
        add( 0 );
        add( 0 );
    }};
    private final static int DEPTH_LIMIT = 3; // this var is temp TODO: Preguntar cómo se implementa DEPTH_LIMIT
    
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
        actions['u'] = () -> coords.set(2, Math.max(coords.get(2) - 1, 0)); // Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido
        actions['r'] = () -> position = position.turnRight();
        actions['l'] = () -> position = position.turnLeft();
        actions['f'] = () -> coords = position.goForward(coords);
        actions['m'] = () -> {
            alive = coords.get(2) <= DEPTH_LIMIT; // Esto es una forma más compleja de if. TODO: Preguntar si esto es válido
            capsuleWasDropped = true;
        };

        command.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> actions[c] != null && alive)
                .forEach(c -> actions[c].run());
    }
}