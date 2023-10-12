package ProyectNemo;

import java.util.ArrayList;

abstract public class Direction {

    abstract public Direction turnRight();
    abstract public Direction turnLeft();
    abstract public ArrayList<Integer> goForward( ArrayList<Integer> coords );
}