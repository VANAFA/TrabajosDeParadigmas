package ProyectNemo;

import java.util.List;
abstract public class Position {

    abstract public Position turnRight();
    abstract public Position turnLeft();
    abstract public List<Integer> goForward( List<Integer> position );
}