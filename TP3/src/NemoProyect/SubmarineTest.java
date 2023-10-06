package NemoProyect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SubmarineTest {
    
    @Test public void test00SubStartsOnSurface() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDepth(), 0);
    }
    @Test public void test01SubStartsAt00() {
        Submarine sub = new Submarine();
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(0); }} );
    }
    @Test public void test02SubStartsLookingNorth() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDirection(), "NORTH");
    }
    @Test public void test03GetNoCommandDoesntMoveAndDoesntChangeDirection() {
        Submarine sub = new Submarine();
        sub.go("");
        assertEquals(sub.getDepth(), 0); 
    }
    @Test public void test04dCommandMakesItGoDown() {
        Submarine sub = new Submarine();
        sub.go("d");
        assertEquals(sub.getDepth(), 1); 
    }
    @Test public void test05uCommandAtSurfaceLevelDoentChangeDepth() {
        Submarine sub = new Submarine();
        sub.go("u");
        assertEquals(sub.getDepth(), 0); 
    }
    @Test public void test06uCommandMakesItGoUp() {
        Submarine sub = new Submarine();
        sub.go("d");
        sub.go("u");
        assertEquals(sub.getDepth(), 0); 
    }
    @Test public void test07rCommandMakesItTurnRight() {
        Submarine sub = new Submarine();
        sub.go("r");
        assertEquals(sub.getDirection(), "EAST"); 
    }
    @Test public void test08lCommandMakesItTurnLeft() {
        Submarine sub = new Submarine();
        sub.go("l");
        assertEquals(sub.getDirection(), "WEST"); 
    }
    @Test public void test09fCommandMakesItGoForward() {
        Submarine sub = new Submarine();
        sub.go("f");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(1); }} ); 
    }
    @Test public void test10ffCommandMakesItGoFowardTwice() {
        Submarine sub = new Submarine();
        sub.go("ff");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(2); }} ); 
    }
    @Test public void test11frflfCommandMakesItGoToOneTwo() {
        Submarine sub = new Submarine();
        sub.go("frflf");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(1); add(2); }} );
    
    }
}
