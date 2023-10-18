package ProyectNemo;

import java.util.ArrayList;

public class DepthState {
    private ArrayList<State> states = new ArrayList<>();

    public DepthState() {
        states.add(new SurfaceLevel());
    }

    public int getDepth() {
        return states.size() - 1;
    }

    public void goDown() {
        actualDepthState().goDown(states);
    }
    
    public void goUp() {
        actualDepthState().goUp(states);
    }
    
    public void dropCapsule() {
        actualDepthState().dropCapsule();
    }
    private State actualDepthState() {
        return states.get( states.size() - 1 );
    }
}

// TODO: preguntar si se puede mergear the clases into one
class State {

    public ArrayList<State> goDown( ArrayList<State> states ) {
        states.add( new TooDeep() );
        return states;
    }

    public ArrayList<State> goUp( ArrayList<State> states ) {
        states.remove( states.size() - 1 );
        return states;
    }

    public void dropCapsule(){
    }
}
class SurfaceLevel extends State {

    @Override public ArrayList<State> goDown( ArrayList<State> states ) { // TODO: preguntar si se puede sacar el Override
        states.add( new Level1() );
        return states;
    }
    @Override public ArrayList<State> goUp( ArrayList<State> states ) {
        return states;
    }
}
class Level1 extends State {
}
class TooDeep extends State {

    @Override public void dropCapsule() {
        throw new RuntimeException("The submarine has been destroyed");
    }
}