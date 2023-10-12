package ProyectNemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import ProyectNemo.directions.*;
public class SubmarineTest {
    
    @Test public void test00SubStartsOnSurface() {
        Submarine sub = new Submarine( List.of(0, 0), new North() );
        assertEquals(sub.getDepth(), 0);
    }
    @Test public void test01SubStartsAt00() {
        Submarine sub = new Submarine( List.of(0, 0), new North() );
        assertEquals(sub.getPosition(), new ArrayList<Integer>() {{ add(0); add(0); }} );
    }
    @Test public void test02SubStartsLookingNorth() {
        Submarine sub = new Submarine( List.of(0, 0), new North() );
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
        assertEquals(moveNewSubmarine("f").getPosition(), new ArrayList<Integer>() {{ add(0); add(1); }} );
    }
    @Test public void test10ffCommandMakesItGoForwardSixTimes() {
        assertEquals(moveNewSubmarine("ffffff").getPosition(), new ArrayList<Integer>() {{ add(0); add(6); }} );
    }
    @Test public void test11frflfCommandMakesItGoToOneTwo() {
        assertEquals(moveNewSubmarine("frflf").getPosition(), new ArrayList<Integer>() {{ add(1); add(2); }} );
    }
    @Test public void test12frfrfrfrCommandMakesItGoToStartingPoint() {
        assertEquals(moveNewSubmarine("frfrfrfr").getPosition(), new ArrayList<Integer>() {{ add(0); add(0); }} );
    }
    @Test public void test13mCommandDropsTheCapsule() {
        Submarine sub = new Submarine( List.of(0, 0), new North() );
        assertTrue(sub.hasCapsule());
        sub.go("m");
        assertFalse(sub.hasCapsule());
    }
    @Test public void test14theSubThrowsDestroyedErrorIfTheCapsuleIsDropedAboveDepthLimit() {
        Submarine sub = new Submarine( List.of(0, 0), new North() );
        assertThrows(Submarine.Destroyed.class, () -> sub.go("dddm"));
    }

    private Submarine moveNewSubmarine(String command) {
        Submarine sub = new Submarine( List.of(0, 0), new North() );
        sub.go(command);
        return sub;
    }
}
