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
        assertEquals(moveNewSubmarine("").getDepth(), 0);
    }
    @Test public void test04dCommandMakesItGoDown() {
        assertEquals(moveNewSubmarine("d").getDepth(), 1);
    }
    @Test public void test05uCommandAtSurfaceLevelDoesntChangeDepth() {
        assertEquals(moveNewSubmarine("u").getDepth(), 0);
    }
    @Test public void test06ddduddCommandMakesItGoToDepth4() {
        assertEquals(moveNewSubmarine("dddudd").getDepth(), 4);
    }
    @Test public void test07rCommandMakesItTurnRight() {
        assertEquals(moveNewSubmarine("r").getDirection(), "East");
    }
    @Test public void test08FourEqualTurnsItGoToTheSameDirection() {
        assertEquals(moveNewSubmarine("rllll").getDirection(),moveNewSubmarine("rrrrr").getDirection() ,moveNewSubmarine("r").getDirection());
    }
    @Test public void test09fCommandMakesItGoForward() {
        assertEquals(moveNewSubmarine("f").getPosition(), new ArrayList<Integer>() {{ add(0); add(1); add(0); }} );
    }
    @Test public void test10ffCommandMakesItGoForwardSixTimes() {
        assertEquals(moveNewSubmarine("ffffff").getPosition(), new ArrayList<Integer>() {{ add(0); add(6); add(0); }} );
    }
    @Test public void test11frflfCommandMakesItGoToOneTwo() {
        assertEquals(moveNewSubmarine("frflf").getPosition(), new ArrayList<Integer>() {{ add(1); add(2); add(0); }} );
    }
    @Test public void test12frflffCommandMakesItGoToOneThree() {
        assertEquals(moveNewSubmarine("frflff").getPosition(), new ArrayList<Integer>() {{ add(1); add(3); add(0); }} );
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
    private Submarine moveNewSubmarine(String command) {
        Submarine sub = new Submarine();
        sub.go(command);
        return sub;
    }
}
