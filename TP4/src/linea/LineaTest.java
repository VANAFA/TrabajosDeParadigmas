package linea;

import static org.junit.Assert.*;
import org.junit.Test;
import linea.gameStates.*;

public class LineaTest {
    
   @Test
   public void test00CanNotMakeBoard00() {
        assertThrows( RuntimeException.class, () -> new Linea(0, 0, 'c') );
   } 

   @Test
   public void test01CanNotMakeBoardNegative() {
        assertThrows( RuntimeException.class, () -> new Linea(-1, -1, 'c') );
   }

    @Test
    public void test02GameModeWithCapitalLettersWorks() {
        Linea game = new Linea(5, 5, 'C');
        assertEquals('c', game.getGameMode());
    }

    @Test
    public void test03xStartsPlaying() {
        Linea game = new Linea(5, 5, 'c');
        assertTrue(game.getCurrentPlayer() instanceof PlayingRed);
    }

    @Test
    public void test04xPlaysAt00() {
        Linea game = newGamePlayAt0();
        assertEquals(1, game.getPlayerAt(0, 0));
    }
    
    @Test
    public void test05CanNotPlayOutOfBounds() {
        Linea game = new Linea(4, 4, 'c');
        assertThrows( RuntimeException.class, () -> game.playRedAt(-1) );
        assertThrows( RuntimeException.class, () -> game.playRedAt(4) );
    }

    @Test
    public void test06oPlaysAt01() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(1);
        assertEquals(2, game.getPlayerAt(0, 1));
    }

    @Test
    public void test07TurnsAreRespected() {
        Linea game = newGamePlayAt0();
        assertTrue(game.getCurrentPlayer() instanceof PlayingBlue);
        game.playBlueAt(0);
        assertTrue(game.getCurrentPlayer() instanceof PlayingRed);
    }

    @Test
    public void test08RedCanNotPlayOnBlueTurn() {
        Linea game = newGamePlayAt0();
        assertThrows( RuntimeException.class, () -> game.playRedAt(0) );
    }

    @Test
    public void test09BlueCanNotPlayOnRedTurn() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(0);
        assertThrows( RuntimeException.class, () -> game.playBlueAt(0) );
    }

    @Test
    public void test10finishedWorks() {
        Linea game = new Linea(4, 4, 'c');
        assertFalse(game.finished());
        game = diagonalWin('c');
        assertTrue(game.finished());
    }

    @Test
    public void test11CanNotPlayAfterGameIsFinished() {
        Linea game = diagonalWin('c');
        assertThrows( RuntimeException.class, () -> game.playBlueAt(1) );
    }

    @Test
    public void test12verticalWinWorks() {
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
    public void test13horizontalWinWorks() {
        Linea game = newGamePlayAt0();
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        assertTrue(game.checkWin(1));
    }       
    
    @Test
    public void test14diagonalWinWorks() {
        Linea game = diagonalWin('c');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test15winWorksOnAnySizeBoard() {
        Linea game = diagonalWin('c');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test16DrawWorksIfNoneWins() {
        Linea game = diagonalWin('a');
        game.playBlueAt(0);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(0);
        assertTrue(game.finished());
        assertTrue(game.isDraw());
    }

    @Test
    public void test17GameModeADoesNotAcceptDiagonalWins() {
        Linea game = diagonalWin('a');
        assertFalse(game.finished());
    }

    @Test
    public void test18GameModeBOnlyDiagonalWin() {
        Linea game = diagonalWin('b');
        assertTrue(game.checkWin(1));
    }

    private Linea newGamePlayAt0() {
        Linea game = new Linea(4, 4, 'c');
        game.playRedAt(0);
        return game;
    }

    private Linea diagonalWin( char gameMode) {
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