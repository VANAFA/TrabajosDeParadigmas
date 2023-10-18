package ProyectNemo;

//import java.util.ArrayList; // preferably use list // TODO: Preguntar si podemos usar sólo ArrayList
import java.util.ArrayList;
import java.util.Arrays; // TODO: preguntar si esto el legal

// we can't use hash map, nor if statements nor switch statements
// TODO: depth is a bad name, we need to medir the capacity of the sub to shoot or not

// TODO: Preguntar si es válido usar tantos importes, en directions también

public class Submarine {
    
    private ArrayList<Integer> coords;
    private Direction direction;
    private DepthState depthState;

    public Submarine( ArrayList<Integer> coords, Direction direction ) {
        this.direction = direction;
        this.depthState = new SurfaceLevel();
        // this.depthLimit = depthLimit;
        // this.coords = new ArrayList<>(coords);
        // coords.add(0);
    } // TODO: la cápsula se puede tirar en la superficie o en el niverl 1 de profundidad
    // superficie, nivel1, muy profundo

    public ArrayList<Integer> getPosition() {
        return coords;
    }
    
    public int getDepth() {
        return depthState.getDepth();
    }

    public String getDirection() {
        return direction.getClass().getSimpleName();
    }

     // use can handdle to make the commands
    public void go(String command) {
        Action[] actions = {new Forward(), new Left(), new Right(), new DropCapsule(), new Down(), new Up()};
        command.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> Arrays.stream(actions).anyMatch(action -> action.canHandle(c)))
            .forEach(c -> Arrays.stream(actions)
                .filter(action -> action.canHandle(c))
                .findFirst()
                .ifPresent(action -> direction = action.run(coords, direction)));
    }
}

// Runnable[] actions = new Runnable[128];
// actions['d'] = () -> depth += 1;
// actions['u'] = () -> depth = Math.max(depth - 1, 0); // Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido
// actions['r'] = () -> direction = direction.turnRight();
// actions['l'] = () -> direction = direction.turnLeft();
// actions['f'] = () -> coords = direction.goForward(coords);
// actions['m'] = () -> {if (depth > depthLimit) {
//             throw new RuntimeException("The sub was destroyed!"); // Try to get rid of the if
//         } else {
//                 capsuleWasDropped = true;
//             }
//         };
        
//         command.chars()
//                 .mapToObj(c -> (char) c)
//                 .filter(c -> actions[c] != null )
//                 .forEach(c -> actions[c].run());
        

// Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido