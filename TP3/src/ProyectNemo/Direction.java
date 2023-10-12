package ProyectNemo;

import java.util.List;

import ProyectNemo.directions.North;
abstract public class Direction {

    abstract public Direction turnRight();
    abstract public Direction turnLeft();
    abstract public List<Integer> goForward( List<Integer> position );
}