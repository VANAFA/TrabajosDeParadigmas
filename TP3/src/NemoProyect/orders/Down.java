package NemoProyect.orders;

import NemoProyect.Command;
import NemoProyect.Position;

public class Down extends Command {

    public void go( Position position ) {
        position.goDown();
    }
}
