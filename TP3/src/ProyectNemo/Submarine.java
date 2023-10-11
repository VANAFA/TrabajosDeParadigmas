package ProyectNemo; // TODO: hay que poder elegir las coordenadas que los test quieran, mirando a la dirección que quiera

import java.util.ArrayList; // preferably use list // TODO: Preguntar si podemos usar sólo ArrayList
import java.util.List;

import ProyectNemo.directions.North; // TODO: Preguntar si es válido usar tantos importes, en directions también

public class Submarine {
    private Position position = new North();
    private Boolean capsuleWasDropped = false;
    private Boolean alive = true;
    private List<Integer> coords = new ArrayList<Integer>() {{
        add( 0 );
        add( 0 );
        add( 0 );
    }};
    private final static int DEPTH_LIMIT = 3; // this var is temp TODO: Preguntar cómo se implementa DEPTH_LIMIT

    public Boolean isAlive() { // TODO: Fijarse si se puede hacer la variable y el método para llamarla directamente en el método init (Submarine())
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
    // hacer un métdo que ejecute comandos, el go
    // hacer un método que chequee un movimiento, el caracter
    // n vas al norte y recibís r, vas al este.
    // give error message if command is not valid
    // calse posición, dirección, y comando
    
    public void go( String command ) {

        Runnable[] actions = new Runnable[128];
        actions['d'] = () -> coords.set(2, coords.get(2) + 1);
        actions['u'] = () -> coords.set(2, Math.max(coords.get(2) - 1, 0)); // Math.max impide que el valor sea negativo TODO: Preguntar si esto es válido
        actions['r'] = () -> position = position.turnRight();
        actions['l'] = () -> position = position.turnLeft();
        actions['f'] = () -> coords = position.goForward(coords);
        actions['m'] = () -> {
            alive = coords.get(2) <= DEPTH_LIMIT; // TODO: Preguntar si esto es válido
            capsuleWasDropped = true; // TODO: si el submarino explota, tirar error
        };

        command.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> actions[c] != null && alive)
                .forEach(c -> actions[c].run());
    }
}

// de las clases de direcciones, salen la clase Command (no extiende a nadie) (métodos ,can handle, go move), y de ahí los comandos.