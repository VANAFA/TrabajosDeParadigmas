package linea.size;

public class InvalidSize extends Size {
    
    public void check() {
        throw new IllegalArgumentException("Invalid dimensions");
    }
}
