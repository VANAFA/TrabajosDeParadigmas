package ProyectNemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import ProyectNemo.directions.*;

public class SubmarineTest {

    @Test
    public void test00SubStartsOnSurface() {
        Submarine sub = new Submarine(originCoords, new North());
        assertEquals(sub.getDepth(), 0);
    }

    @Test
    public void test01SubStartsAt00() {
        Submarine sub = new Submarine(originCoords, new North());
        assertEquals(sub.position, originCoords);
    }

    @Test
    public void test02SubStartsFacingNorth() {
        Submarine sub = new Submarine(originCoords, new North());
        assertEquals(sub.getDirection(), "North");
    }

    @Test
    public void test03GetNoCommandDoesntMoveAndDoesntChangeDirection() {
        assertEquals(moveNewSubmarine("").getDepth(), 0);
    }

    @Test
    public void test04dCommandMakesItGoDown() {
        assertEquals(moveNewSubmarine("d").getDepth(), 1);
    }

    @Test
    public void test05uCommandAtSurfaceLevelDoesntChangeDepth() {
        assertEquals(moveNewSubmarine("u").getDepth(), 0);
    }

    @Test
    public void test06ddduddCommandMakesItGoToDepth4() {
        assertEquals(moveNewSubmarine("dddudd").getDepth(), 4);
    }

    @Test
    public void test07lCommandMakesItTurnRight() {
        assertEquals(moveNewSubmarine("l").getDirection(), west);
    }

    @Test
    public void test08fourEqualTurnsMakeItGoToTheSameDirection() {
        assertEquals(moveNewSubmarine("rllll").getDirection(), moveNewSubmarine("rrrrr").getDirection(), moveNewSubmarine("r").getDirection());
    }

    @Test
    public void test09fCommandMakesItGoForward() {
        assertEquals(moveNewSubmarine("f").position, getPoint(0, 1));
    }

    @Test
    public void test10ffffffCommandMakesItGoForwardSixTimes() {
        assertEquals(moveNewSubmarine("ffffff").position, getPoint(0, 6));
    }

    @Test
    public void test11frflfCommandMakesItGoToOneTwo() {
        assertEquals(moveNewSubmarine("frflf").position, getPoint(1, 2));
    }

    @Test
    public void test12frfrfrfrCommandMakesItGoToStartingPoint() {
        assertEquals(moveNewSubmarine("frfrfrfr").position, originCoords);
    }

    @Test
    public void test13ifCapsuleIsDroppedAtSurfaceLevelNothingHappensToPositionNorDirection() {
        Submarine sub = moveNewSubmarine("lfffffrflm");
        assertEquals(sub.position, getPoint(-5, 1));
        assertEquals(sub.getDirection(), west);
        assertEquals(sub.getDepth(), 0);
    }

    @Test
    public void test14ifCapsuleIsDroppedAtDepthLevelOneNothingHappensToPositionNorDirection() {
        Submarine sub = moveNewSubmarine("fflffddfrfuflm");
        assertEquals(sub.position, getPoint(-3, 4));
        assertEquals(sub.getDirection(), west);
        assertEquals(sub.getDepth(), 1);
    }

    @Test
    public void test15theSubThrowsDestroyedErrorIfTheCapsuleIsDroppedBelowDepthLimit() {
        Submarine sub = new Submarine(originCoords, new North());
        assertThrows(RuntimeException.class, () -> sub.go("ddddm"));
    }

    @Test
    public void test16expectAnErrorIfAnInvalidCommandIsGiven() {
        Submarine sub = new Submarine(originCoords, new North());
        assertThrows(RuntimeException.class, () -> sub.go("x"));
    }

    private Submarine moveNewSubmarine(String command) {
        Submarine sub = new Submarine(originCoords, new North());
        sub.go(command);
        return sub;
    }

    private ArrayList<Integer> getPoint(Integer x, Integer y) {
        ArrayList<Integer> point = new ArrayList<Integer>();
        point.add(x);
        point.add(y);
        return point;
    }

    private final ArrayList<Integer> originCoords = getPoint(0, 0);
    private static final String west = "West";
}
// TODO: Remove this
// (maybe) refactorear test14 y test15 con una funcion que haga el new submarine y el assert throws