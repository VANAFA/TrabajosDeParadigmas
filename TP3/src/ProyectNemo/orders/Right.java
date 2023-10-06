package ProyectNemo.orders;

import ProyectNemo.Command;
import ProyectNemo.Position;

public class Right extends Command {

    public void go( Position position ) {
        position = position.turnRight();
    }
}
