package NemoProyect.orders;

import NemoProyect.Command;
import NemoProyect.Position;

public class Foward extends Command {

    public void go( Position position ) {
        position.goFoward();
    }
}
