package NemoProyect.orders;

import NemoProyect.Command;
import NemoProyect.Position;

public class Left extends Command {

    public void go( Position position ) {
        position = position.turnLeft();
    }
}
