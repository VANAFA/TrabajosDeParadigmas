package ProyectNemo.orders;

import ProyectNemo.Command;
import ProyectNemo.Position;

public class Left extends Command {

    public void go( Position position ) {
        position = position.turnLeft();
    }
}
