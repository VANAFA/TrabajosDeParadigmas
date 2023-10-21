package ProyectNemo;

abstract public class Action {
    abstract public Boolean canHandle( char command );
    abstract public void run( Submarine sub );
}