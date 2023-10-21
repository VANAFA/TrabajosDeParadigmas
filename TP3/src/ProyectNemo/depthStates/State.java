package ProyectNemo.depthStates;

import java.util.List;

public class State {

    public List<State> goDown( List<State> states ) {
        states.add( new TooDeep() );
        return states;
    }

    public List<State> goUp( List<State> states ) {
        states.remove( states.size() - 1 );
        return states;
    }

    public void dropCapsule(){
    }
}