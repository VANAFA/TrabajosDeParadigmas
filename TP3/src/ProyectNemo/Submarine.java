package ProyectNemo; // TODO: hay que poder elegir las coordenadas que los test quieran, mirando a la dirección que quiera

//import java.util.ArrayList; // preferably use list // TODO: Preguntar si podemos usar sólo ArrayList
import java.util.List;

import ProyectNemo.directions.*; // TODO: Preguntar si es válido usar tantos importes, en directions también

public class Submarine {
    
    private List<Integer> coords;
    private Direction direction;
    private Boolean capsuleWasDropped = false;
    private Integer depth = 0;
        //private final static int DEPTH_LIMIT = 3; // this var is temp

        // we need to have the posibility to start the sub anywhere, and looking at any direction
        // how? we need to have a constructor that receives the coords and the direction:

    public Submarine( List<Integer> coords, Direction direction ) {
        this.coords = coords;
        this.direction = direction;
    }


    public List<Integer> getPosition() {
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
    
    public void go( String command ) {

        // this needs replacement
        // Runnable[] actions = new Runnable[128];
        // actions['d'] = () -> coords.set(2, coords.get(2) + 1);
        // actions['u'] = () -> coords.set(2, Math.max(coords.get(2) - 1, 0)); // Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido
        // actions['r'] = () -> direction = direction.turnRight();
        // actions['l'] = () -> direction = direction.turnLeft();
        // actions['f'] = () -> coords = direction.goForward(coords);
        // actions['m'] = () -> capsuleWasDropped = true; // This command just destroys the sub if executed surpassing the depth limit TODO: si el submarino explota, tirar error

        // command.chars()
        //         .mapToObj(c -> (char) c)
        //         .filter(c -> actions[c] != null )
        //         .forEach(c -> actions[c].run());
    }
}

// de las clases de direcciones, salen la clase Command (no extiende a nadie) (métodos ,can handle, go move), y de ahí los comandos.