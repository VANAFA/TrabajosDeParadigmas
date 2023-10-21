package ProyectNemo;

import java.util.ArrayList;
import ProyectNemo.depthStates.State;
import ProyectNemo.depthStates.SurfaceLevel;

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