package linea;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.stream.IntStream;
import linea.gameStates.*;

public class LineaTest { // al final que ordenar los test y ponerle los números correctos

    @Test
    public void test00GameModeWithCapitalLettersWorks() {
        Linea game = new Linea(5, 5, 'C');
        assertEquals('c', game.getGameMode());
    }

    @Test
    public void test00xStartsPlaying() {
        Linea game = new Linea(5, 5, 'c');
        assertTrue(game.getCurrentPlayer() instanceof PlayingRed);
    }

    @Test
    public void test01xPlaysAt00() {
        Linea game = newGamePlayAt0();
        assertEquals(1, game.getPlayerAt(0, 0));
    }
    
    @Test
    public void test02CanNotPlayOutOfBounds() {
        Linea game = new Linea(4, 4, 'c');
        assertThrows( RuntimeException.class, () -> game.playRedAt(-1) );
        assertThrows( RuntimeException.class, () -> game.playRedAt(4) );
    }

    @Test
    public void test03oPlaysAt01() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(1);
        assertEquals(2, game.getPlayerAt(0, 1));
    }

    @Test
    public void test02TurnsAreRespected() {
        Linea game = newGamePlayAt0();
        assertTrue(game.getCurrentPlayer() instanceof PlayingBlue);
        game.playBlueAt(0);
        assertTrue(game.getCurrentPlayer() instanceof PlayingRed);
    }

    @Test
    public void test03RedCanNotPlayOnBlueTurn() {
        Linea game = newGamePlayAt0();
        assertThrows( RuntimeException.class, () -> game.playRedAt(0) );
    }

    @Test
    public void test03BlueCanNotPlayOnRedTurn() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(0);
        assertThrows( RuntimeException.class, () -> game.playBlueAt(0) );
    }

    @Test
    public void test04finishedWorks() {
        Linea game = new Linea(4, 4, 'c');
        assertFalse(game.finished());
        game.playRedAt(0); // try using a loop
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        assertTrue(game.finished());
    }

    @Test
    public void test05CanNotPlayAfterGameIsFinished() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        assertThrows( RuntimeException.class, () -> game.playBlueAt(1) );
    }

    @Test
    public void test06verticalWinWorks() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test07horizontalWinWorks() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        assertTrue(game.checkWin(1)); // win isn't working
    }       

    @Test
    public void test08diagonalWinWorks() {
        Linea game = diagonalWin('c');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test09winWorksOnAnySizeBoard() {
        Linea game = diagonalWin('c');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test10DrawWorksIfNoneWins() {
        Linea game = diagonalWin('a');
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(2);
        assertTrue(game.finished());
        assertTrue(game.isDraw());
    }

    @Test
    public void test11GameModeADoesNotAcceptDiagonalWins() {
        Linea game = diagonalWin('a');
        assertFalse(game.finished());
    }

    @Test
    public void test12GameModeBOnlyDiagonalWin() {
        Linea game = diagonalWin('b');
        assertTrue(game.checkWin(1));
    }

    private Linea newGamePlayAt0() {
        Linea game = new Linea(4, 4, 'c');
        game.playRedAt(0);
        return game;
    }

    private Linea diagonalWin( char gameMode) { // TODO: try making this with a loop
        Linea game = new Linea(4, 4, gameMode);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(1);
        game.playRedAt(3);
        return game;
    }
}