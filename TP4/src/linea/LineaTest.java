package linea;

import org.junit.Test;
import static org.junit.Assert.*;

public class LineaTest {

    @Test
    public void testPlay() {
        Linea linea = new Linea(4, 4, 'N');
        assertTrue(linea.play(0, 0));
        assertFalse(linea.play(0, 0));
        assertTrue(linea.play(1, 1));
        assertFalse(linea.play(1, 1));
    }

    @Test
    public void testCheckWin() {
        Linea linea = new Linea(4, 4, 'N');
        assertFalse(linea.checkWin(1));
        assertFalse(linea.checkWin(2));
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        assertTrue(linea.checkWin(1));
        assertFalse(linea.checkWin(2));
        linea = new Linea(4, 4, 'C');
        assertFalse(linea.checkWin(1));
        assertFalse(linea.checkWin(2));
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        assertFalse(linea.checkWin(1));
        assertTrue(linea.checkWin(2));
    }

    @Test
    public void testIsDraw() {
        Linea linea = new Linea(4, 4, 'N');
        assertFalse(linea.isDraw());
        linea.play(0, 0);
        linea.play(0, 1);
        linea.play(0, 2);
        linea.play(1, 0);
        linea.play(1, 1);
        linea.play(1, 2);
        linea.play(2, 0);
        linea.play(2, 1);
        linea.play(2, 2);
        assertFalse(linea.isDraw());
        linea.play(3, 0);
        linea.play(3, 1);
        linea.play(3, 2);
        linea.play(3, 3);
        assertTrue(linea.isDraw());
    }

    @Test
    public void testSwitchPlayer() {
        Linea linea = new Linea(4, 4, 'N');
        assertEquals(1, linea.getCurrentPlayer());
        linea.switchPlayer();
        assertEquals(2, linea.getCurrentPlayer());
        linea.switchPlayer();
        assertEquals(1, linea.getCurrentPlayer());
    }

    @Test
    public void testFinished() {
        Linea linea = new Linea(4, 4, 'N');
        assertFalse(linea.finished());
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        assertTrue(linea.finished());
        linea = new Linea(4, 4, 'C');
        assertFalse(linea.finished());
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        assertTrue(linea.finished());
        linea = new Linea(4, 4, 'N');
        assertFalse(linea.finished());
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        linea.play(2, 2);
        linea.play(3, 3);
        assertFalse(linea.finished());
    }

    @Test
    public void testPlayRedAt() {
        Linea linea = new Linea(4, 4, 'N');
        linea.playRedAt(0);
        assertEquals(1, linea.getBoard()[0][0]);
        assertEquals(2, linea.getCurrentPlayer());
        linea.playRedAt(0);
        assertEquals(1, linea.getBoard()[1][0]);
        assertEquals(1, linea.getCurrentPlayer());
        linea.playRedAt(0);
        assertEquals(1, linea.getBoard()[2][0]);
        assertEquals(2, linea.getCurrentPlayer());
        linea.playRedAt(0);
        assertEquals(1, linea.getBoard()[3][0]);
        assertEquals(1, linea.getCurrentPlayer());
        assertFalse(linea.playRedAt(0));
        assertEquals(1, linea.getBoard()[3][0]);
        assertEquals(1, linea.getCurrentPlayer());
    }

    @Test
    public void testPlayBlueAt() {
        Linea linea = new Linea(4, 4, 'C');
        linea.playBlueAt(0);
        assertEquals(2, linea.getBoard()[0][0]);
        assertEquals(1, linea.getCurrentPlayer());
        linea.playBlueAt(0);
        assertEquals(2, linea.getBoard()[1][0]);
        assertEquals(2, linea.getCurrentPlayer());
        linea.playBlueAt(0);
        assertEquals(2, linea.getBoard()[2][0]);
        assertEquals(1, linea.getCurrentPlayer());
        linea.playBlueAt(0);
        assertEquals(2, linea.getBoard()[3][0]);
        assertEquals(2, linea.getCurrentPlayer());
        assertFalse(linea.playBlueAt(0));
        assertEquals(2, linea.getBoard()[3][0]);
        assertEquals(2, linea.getCurrentPlayer());
    }

    @Test
    public void testShow() {
        Linea linea = new Linea(4, 4, 'N');
        assertEquals("....\n....\n....\n....\n", linea.show());
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        assertEquals("XOX.\nOX..\n....\n....\n", linea.show());
        linea = new Linea(4, 4, 'C');
        assertEquals("....\n....\n....\n....\n", linea.show());
        linea.play(0, 0);
        linea.play(1, 1);
        linea.play(0, 1);
        linea.play(1, 2);
        linea.play(0, 2);
        assertEquals("OXX.\nXO..\n....\n....\n", linea.show());
    }
}