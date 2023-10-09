package ProyectNemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SubmarineTest {
    
    @Test public void test00SubStartsOnSurface() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDepth(), 0);
    }
    @Test public void test01SubStartsAt00() {
        Submarine sub = new Submarine();
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(0); add(0); }} );
    }
    @Test public void test02SubStartsLookingNorth() {
        Submarine sub = new Submarine();
        assertEquals(sub.getDirection(), "North");
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
        assertEquals(sub.getDirection(), "East"); 
    }
    @Test public void test08lCommandMakesItTurnLeft() {
        Submarine sub = new Submarine();
        sub.go("l");
        assertEquals(sub.getDirection(), "West"); 
    }
    @Test public void test09fCommandMakesItGoForward() {
        Submarine sub = new Submarine();
        sub.go("f");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(1); add(0); }} ); 
    }
    @Test public void test10ffCommandMakesItGoFowardTwice() {
        Submarine sub = new Submarine();
        sub.go("ff");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(2); add(0); }} ); 
    }
    @Test public void test11frflfCommandMakesItGoToOneTwo() {
        Submarine sub = new Submarine();
        sub.go("frflf");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(1); add(2); add(0); }} );
    }
    @Test public void test12frflffCommandMakesItGoToOneThree() {
        Submarine sub = new Submarine();
        sub.go("frflff");
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(1); add(3); add(0); }} );
    }
    @Test public void test13mCommandDropsTheCapsule() {
        Submarine sub = new Submarine();
        assertTrue(sub.hasCapsule());
        sub.go("m");
        assertFalse(sub.hasCapsule());
    }
    @Test public void test14theSubIsDestroyedIfTheCapsuleIsDropedAboveDepthLimit() {
        Submarine sub = new Submarine();
        sub.go("ddddm");
        assertEquals(sub.getDepth(), 4);
        assertFalse(sub.isAlive());
    }
    @Test public void test15theSubDoesntMoveNoMoreIfDestroyed() {
        Submarine sub = new Submarine();
        sub.go("ddddffmff");
        assertFalse(sub.isAlive());
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(2); add(4); }} );
    }
}
