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
    
    public void go(String command) {
        // trasform list command to a list of actions
        // command = "rfflffm" equals to [Right, Forward, Forward, Left, Forward, Forward, Capsule]
        // then, for each action, execute it
        // LETS DO IT:

        Action forward = new Forward();
        Action left = new Left();
        Action right = new Right();
        Action capsule = new DropCapsule();
        Action down = new Down();
        Action up = new Up();

        // command = "rfflffm" equals to [Right, Forward, Forward, Left, Forward, Forward, Capsule]

        ArrayList<Character> commandList = new ArrayList<Character>();
        for (int i = 0; i < command.length(); i++) {
            commandList.add(command.charAt(i));
        }

        // Define a map of characters to actions
        Map<Character, Action> actionsMap = new HashMap<>();
        actionsMap.put('f', forward);
        actionsMap.put('l', left);
        actionsMap.put('r', right);
        actionsMap.put('m', capsule);
        actionsMap.put('d', down);
        actionsMap.put('u', up);

        // Replace each char with its associated action
        ArrayList<Action> actions = new ArrayList<Action>();
        for (char c : commandList) {
            Action action = actionsMap.get(c);
            if (action != null) {
                actions.add(action);
            }
        }

        // Execute each action
        for (Action action : actions) {
            action.run(this);
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