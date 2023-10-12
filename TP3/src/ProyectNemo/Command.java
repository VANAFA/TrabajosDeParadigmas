package ProyectNemo;

import java.util.List;
import ProyectNemo.Direction;

abstract public class Command {
    abstract public void go( List<Integer> coords, Direction direction );
}
