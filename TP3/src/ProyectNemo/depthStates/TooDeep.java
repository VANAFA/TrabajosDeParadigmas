package ProyectNemo.depthStates;

public class TooDeep extends State {

    @Override
    public void dropCapsule() {
        throw new RuntimeException("The submarine has been destroyed from excess chocolate");
    }
}