package ProyectNemo.orders;

import ProyectNemo.Command;
import ProyectNemo.Position;

public class Foward extends Command {

    public void go( Position position ) {
        position.goFoward();
    }
}
