package NemoProyect.orders;

import NemoProyect.Command;
import NemoProyect.Position;

public class Up extends Command {
    
    public void go( Position position ) {
        position.goUp();
    }
}
