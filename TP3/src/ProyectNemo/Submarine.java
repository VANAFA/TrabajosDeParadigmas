package ProyectNemo;

import java.util.ArrayList;
import java.util.Arrays;
// TODO: cambiar el formato a intellij

import ProyectNemo.actions.*;

public class Submarine {
    
    public ArrayList<Integer> coords;
    public Direction direction;
    public DepthState depthState;

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
        Action[] actions = {new Forward(), new Left(), new Right(), new DropCapsule(), new Down(), new Up(), new CommandNotAccepted()};
        command.chars()
            .forEach(c -> Arrays.stream(actions)
                .filter(action -> action.canHandle((char) c))
                .findFirst()
                .ifPresent(action -> action.run( this )));
    }
}