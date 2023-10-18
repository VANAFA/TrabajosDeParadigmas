package ProyectNemo;

import java.util.ArrayList;
import java.util.Arrays;
// TODO: cambiar el formato a intellij

public class Submarine {
    
    private ArrayList<Integer> coords;
    private Direction direction;
    private DepthState depthState;
    // private DepthState initialDepthState;

    public Submarine( ArrayList<Integer> coords, Direction direction ) {
        this.coords = coords;
        this.direction = direction;
        this.depthState = new DepthState();
    }

    public ArrayList<Integer> getPosition() {
        return coords;
    }
    
    public int getDepth() {
        return depthState.getDepth();
    }

    public String getDirection() {
        return direction.getClass().getSimpleName();
    }

    public void go(String command) {
        Action[] actions = {new Forward(), new Left(), new Right(), new DropCapsule(), new Down(), new Up()};
        command.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> Arrays.stream(actions).anyMatch(action -> action.canHandle(c)))
            .forEach(c -> Arrays.stream(actions)
                .filter(action -> action.canHandle(c))
                .findFirst()
                .ifPresent(action -> direction = action.run(coords, direction, depthState)));
    }
}