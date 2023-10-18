package ProyectNemo;

public abstract class DepthState {

    public abstract int getDepth();

}


class SurfaceLevel extends DepthState {
    
    public int getDepth() {
        return 0;
    }
}

class level1 extends DepthState {
    
    public int getDepth() {
        return 1;
    }
}
