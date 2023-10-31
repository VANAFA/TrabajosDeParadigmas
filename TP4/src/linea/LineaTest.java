package linea;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineaTest {

    @Test
    public void test00gameModeCanNotBeInvalid() {
        assertThrows( IllegalArgumentException.class, () -> new Linea(5, 5, 'D') );
    }

    @Test
    public void test01xStartsPlaying() {
        Linea game = new Linea(5, 5, 1);
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test02xPlaysAt00() {
        Linea game = new Linea(5, 5, 1);
        game.play(0, 0);
        assertEquals(1, game.getPosition()[0][0]);
    }

    @Test
    public void test03oPlaysAt00() {
        Linea game = new Linea(5, 5, 1);
        game.play(0, 0);
        game.switchPlayer();
        game.play(0, 1);
        assertEquals(2, game.getPosition()[0][1]);
    }

    @Test
    public void test06verticalWinWorks() {
        Linea game = new Linea(5, 5, 1);
        game.play(0, 0);
        game.switchPlayer();
        game.play(1, 0);
        game.switchPlayer();
        game.play(0, 1);
        game.switchPlayer();
        game.play(1, 1);
        game.switchPlayer();
        game.play(0, 2);
        game.switchPlayer();
        game.play(1, 2);
        game.switchPlayer();
        game.play(0, 3);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test07horizontalWinWorks() {
        Linea game = new Linea(5, 5, 1);
        game.play(0, 0);
        game.switchPlayer();
        game.play(0, 1);
        game.switchPlayer();
        game.play(1, 0);
        game.switchPlayer();
        game.play(1, 1);
        game.switchPlayer();
        game.play(2, 0);
        game.switchPlayer();
        game.play(2, 1);
        game.switchPlayer();
        game.play(3, 0);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test08diagonalWinWorks() {
        Linea game = new Linea(5, 5, 2);
        game.play(0, 0);
        game.switchPlayer();
        game.play(0, 1);
        game.switchPlayer();
        game.play(1, 1);
        game.switchPlayer();
        game.play(1, 2);
        game.switchPlayer();
        game.play(2, 2);
        game.switchPlayer();
        game.play(2, 3);
        game.switchPlayer();
        game.play(3, 3);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test09winWorksOnAnySizeBoard() {
        Linea game = new Linea(8, 5, 3);
        game.play(0, 4);
        game.switchPlayer();
        game.play(0, 5);
        game.switchPlayer();
        game.play(1, 5);
        game.switchPlayer();
        game.play(1, 6);
        game.switchPlayer();
        game.play(2, 6);
        game.switchPlayer();
        game.play(2, 7);
        game.switchPlayer();
        game.play(3, 7);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test10DrawWorksIfNoneWins4x4() {
        Linea game = new Linea(4, 4, 1);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(1);

        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(2);

        game.playRedAt(4);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(3);
        
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(4);


        assertTrue(game.isFinished());
        assertTrue(game.isDraw());
    }

    @Test
    public void test11GameModeADoesNotAcceptDiagonalWins() {
        Linea game = new Linea(5, 5, 1);
        game.play(0, 0);
        game.switchPlayer();
        game.play(0, 1);
        game.switchPlayer();
        game.play(1, 1);
        game.switchPlayer();
        game.play(1, 2);
        game.switchPlayer();
        game.play(2, 2);
        game.switchPlayer();
        game.play(2, 3);
        game.switchPlayer();
        game.play(3, 3);
        assertFalse(game.checkWin(1));
    }

    @Test
    public void test12GameModeBOnlyDiagonalWin() {
        Linea game = new Linea(5, 5, 2);
        game.play(0, 0);
        game.switchPlayer();
        game.play(0, 1);
        game.switchPlayer();
        game.play(1, 1);
        game.switchPlayer();
        game.play(1, 2);
        game.switchPlayer();
        game.play(2, 2);
        game.switchPlayer();
        game.play(2, 3);
        game.switchPlayer();
        game.play(3, 3);
        assertTrue(game.checkWin(1));
    }
}