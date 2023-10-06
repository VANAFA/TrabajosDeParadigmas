package NemoProyect.orders;

import NemoProyect.Command;
import NemoProyect.Position;

public class Right extends Command {

    public void go( Position position ) {
        position = position.turnRight();
    }
}
