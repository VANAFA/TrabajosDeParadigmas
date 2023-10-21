package ProyectNemo.depthStates;

import java.util.List;

public class SurfaceLevel extends State {

    @Override
    public List<State> goDown( List<State> states ) {
        states.add( new LevelOne() );
        return states;
    }

    @Override
    public List<State> goUp( List<State> states ) {
        return states;
    }
}