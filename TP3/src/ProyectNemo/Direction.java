package ProyectNemo;

abstract public class Direction {

    abstract public Direction turnRight();
    abstract public Direction turnLeft();
    abstract public void goForward( Submarine sub );
}