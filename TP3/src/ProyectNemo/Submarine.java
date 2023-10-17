package ProyectNemo;

//import java.util.ArrayList; // preferably use list // TODO: Preguntar si podemos usar sólo ArrayList
import java.util.ArrayList;
import ProyectNemo.orders.*;

// TODO: Preguntar si es válido usar tantos importes, en directions también

public class Submarine {
    
    private ArrayList<Integer> coords;
    private Direction direction;
    private Boolean capsuleWasDropped = false;
    private Integer depthLimit;
    private Integer depth = 0;

    // we need to have the posibility to start the sub anywhere, and looking at any direction
    // how? we need to have a constructor that receives the coords and the direction:

    public Submarine( ArrayList<Integer> coords, Direction direction, Integer depthLimit ) {
        this.coords = coords;
        this.direction = direction;
        this.depthLimit = depthLimit;
    }

    public ArrayList<Integer> getPosition() {
        return coords;
    }
    
    public int getDepth() {
        return depth;
    }

    public String getDirection() {
        return direction.getClass().getSimpleName();
    }

    public Boolean hasCapsule() {
        return !capsuleWasDropped;
    }
    // hacer un métdo que ejecute comandos, el go
    // hacer un método que chequee un movimiento, el caracter
    // n vas al norte y recibís r, vas al este.
    // give error message if command is not valid
    // calse posición, dirección, y comando
    
    public void go(String command) { // this method for each character on the command string, associates it with a class.

    Runnable[] actions = new Runnable[128];
    actions['d'] = () -> depth += 1;
    actions['u'] = () -> depth = Math.max(depth - 1, 0); // Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido
    actions['r'] = () -> direction = direction.turnRight();
    actions['l'] = () -> direction = direction.turnLeft();
    actions['f'] = () -> coords = direction.goForward(coords);
    actions['m'] = () -> {if (depth > depthLimit) {
            throw new RuntimeException("The sub was destroyed!"); // Try to get rid of the if
        } else {
            capsuleWasDropped = true;
        }
    };
    
    command.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> actions[c] != null )
            .forEach(c -> actions[c].run()); 
    }

    private Action readOrder( Char order ) { // this cant use switch case nor if. this must make the order into a class. like a factory
        // this method must return a class, that will be executed by the go method. like d must be class Down
        
        if (order == 'd') {
            return new Down();
        } else if (order == 'u') {
            return new Up();
        } else if (order == 'r') {
            return new Right();
        } else if (order == 'l') {
            return new Left();
        } else if (order == 'f') {
            return new Forward();
        } else if (order == 'm') {
            return new Drop();
        } else {
            return new Error();

        }
        
    }
}

// Runnable[] actions = new Runnable[128];
// actions['d'] = () -> depth += 1;
// actions['u'] = () -> depth = Math.max(depth - 1, 0); // Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido
// actions['r'] = () -> direction = direction.turnRight();
// actions['l'] = () -> direction = direction.turnLeft();
// actions['f'] = () -> coords = direction.goForward(coords);
// actions['m'] = () -> {if (depth > depthLimit) {
    //         throw new RuntimeException("The sub was destroyed!"); // Try to get rid of the if
    //     } else {
        //         capsuleWasDropped = true;
        //     }
        // };
        
        // command.chars()
        //         .mapToObj(c -> (char) c)
        //         .filter(c -> actions[c] != null )
        //         .forEach(c -> actions[c].run());
        
        
// // Define an array of classes, where each index corresponds to a specific character
// Class<?>[] actions = new Class<?>[128];
// actions['d'] = DepthAction.class;
// actions['u'] = DepthAction.class;
// actions['r'] = TurnRightAction.class;
// actions['l'] = TurnLeftAction.class;
// actions['f'] = GoForwardAction.class;
// actions['m'] = CapsuleAction.class;

// // Loop through each character in the command string
// for (int i = 0; i < command.length(); i++) {
//     char c = command.charAt(i);
//     // Get the class corresponding to the character
//     Class<?> actionClass = actions[c];
//     if (actionClass != null) {
//         try {
//             // Create an instance of the class and invoke its run method
//             Action action = (Action) actionClass.newInstance();
//             action.run(this);
//         } catch (InstantiationException | IllegalAccessException e) {
//             // Handle any exceptions that may occur
//             e.printStackTrace();