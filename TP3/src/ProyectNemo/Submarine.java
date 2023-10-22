package ProyectNemo;

import java.util.ArrayList;
import java.util.Arrays;
import ProyectNemo.actions.*;

public class Submarine {

    public ArrayList<Integer> position;
    public Direction direction;
    public DepthState depthState;
    
    public Submarine( ArrayList<Integer> position, Direction direction ) {
        this.position = position;
        this.direction = direction;
        this.depthState = new DepthState();
    }
    
    public void go(String command) {
        Action[] actions = {new Forward(), new Left(), new Right(), new DropCapsule(), new Down(), new Up(), new CommandNotAccepted()};
        command.chars().forEach(c -> Arrays.stream(actions)
                                            .filter(action -> action.canHandle((char) c))
                                            .findFirst().ifPresent(action -> action.run( this )));
    }

    public int getDepth() {
        return depthState.getDepth();
    }

    public String getDirection() {
        return direction.getClass().getSimpleName();
    }
}