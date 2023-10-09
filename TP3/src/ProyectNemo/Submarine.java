package ProyectNemo;

import java.util.ArrayList; // preferably use list
import java.util.List;
// import java.util.HashMap;
// import java.util.Map;

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

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'd' && alive ) {
                coords.set(2, coords.get(2) + 1 );
            } else if (command.charAt(i) == 'u' && coords.get(2) > 0 && alive ) {
                coords.set(2, coords.get(2) - 1 );
            } else if (command.charAt(i) == 'r' && alive ) {
                position = position.turnRight();
            } else if (command.charAt(i) == 'l' && alive ) {
                position = position.turnLeft();
            } else if (command.charAt(i) == 'f' && alive ) {
                coords = position.goFoward( coords );
            } else if (command.charAt(i) == 'm' && alive ) {
                if ( coords.get(2) > depthLimit ){
                    alive = false;
                }
                capsuleWasDropped = true;
            }
            
            // perharps we can use a list of commands and a list of actions, and then iterate over them
            // but we need to find a way to make the actions work with the commands
        }
    }
}



// cant use hashmap nor ifs nor switch case. We need to find another way.

// Map<Character, Runnable> actions = new HashMap<>();
// actions.put('d', () -> coords.set(2, position.goDown( coords.get(2))));
// actions.put('u', () -> coords.set(2, position.goUp( coords.get(2))));
            // actions.put('r', () -> position = position.turnRight());
            // actions.put('l', () -> position = position.turnLeft());
            // actions.put('f', () -> coords = position.goFoward( coords ));
            // actions.put('m', () -> capsuleWasDropped = position.dropCapsule( depthLimit, coords.get(2), alive ));
    
            // command.chars().forEach(c -> actions.get((char) c).run());