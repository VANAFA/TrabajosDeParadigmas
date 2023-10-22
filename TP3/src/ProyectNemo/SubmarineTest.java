package ProyectNemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import ProyectNemo.directions.*;

public class SubmarineTest {
    
    @Test public void test00SubStartsOnSurface() {
        Submarine sub = new Submarine( basicCoords, new North());
        assertEquals(sub.getDepth(), 0);
    }
    @Test public void test01SubStartsAt00() {
        Submarine sub = new Submarine( basicCoords, new North());
        assertEquals(sub.position, basicCoords );
    }
    @Test public void test02SubStartsLookingNorth() {
        Submarine sub = new Submarine( basicCoords, new North());
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
    @Test public void test08FourEqualTurnsMakeItGoToTheSameDirection() {
        assertEquals(moveNewSubmarine("rllll").getDirection(),moveNewSubmarine("rrrrr").getDirection() ,moveNewSubmarine("r").getDirection());
    }
    @Test public void test09fCommandMakesItGoForward() {
        assertEquals(moveNewSubmarine("f").position, getPoint(0,1) );
    }
    @Test public void test10ffCommandMakesItGoForwardSixTimes() {
        assertEquals(moveNewSubmarine("ffffff").position, getPoint(0,6) );
    }
    @Test public void test11frflfCommandMakesItGoToOneTwo() {
        assertEquals(moveNewSubmarine("frflf").position, getPoint(1,2) );
    }
    @Test public void test12frfrfrfrCommandMakesItGoToStartingPoint() {
        assertEquals(moveNewSubmarine("frfrfrfr").position, basicCoords );
    }
    @Test public void test13ifCapsuleIsDroppedUnderTheDepthLimitNothingHappensToPositionNorDirection() {
        Submarine sub = moveNewSubmarine( "fflffddfrfufl" );
        assertEquals(sub.position, getPoint(-3, 4));
        assertEquals(sub.getDirection(), "West");
        assertEquals(sub.getDepth(), 1);
    }
    @Test public void test14theSubThrowsDestroyedErrorIfTheCapsuleIsDropedAboveDepthLimit() {
        Submarine sub = new Submarine( basicCoords, new North());
        assertThrows(RuntimeException.class, () -> sub.go("ddddm"));
    }
    @Test public void test15expectAnErrorIfAnInvalidCommandIsGiven() {
        Submarine sub = new Submarine( basicCoords, new North());
        assertThrows(RuntimeException.class, () -> sub.go("x"));
    }

    private Submarine moveNewSubmarine(String command) {
        Submarine sub = new Submarine( basicCoords, new North());
        sub.go(command);
        return sub;
    }
    private ArrayList<Integer> getPoint(Integer x, Integer y) {
        ArrayList<Integer> point = new ArrayList<Integer>();
        point.add(x);
        point.add(y);
        return point;
    }

    private ArrayList<Integer> basicCoords = getPoint(0, 0);
}