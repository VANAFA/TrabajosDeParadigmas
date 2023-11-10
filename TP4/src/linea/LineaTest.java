package linea;

import org.junit.Test;
import java.util.stream.IntStream;
import static org.junit.Assert.*;

public class LineaTest { // al final que ordenar los test y ponerle los números correctos

    @Test
    public void test00GameModeWithCapitalLettersWorks() {
        Linea game = new Linea(5, 5, 'C');
        assertEquals('C', game.getGameMode());
    }

    @Test
    public void test00xStartsPlaying() {
        Linea game = new Linea(5, 5, 'C');
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test01xPlaysAt00() {
        Linea game = newGamePlayAt0();
        assertEquals(1, game.getPlayerAt(3, 0));
    }

    @Test
    public void test02TurnsAreRespected() {
        Linea game = newGamePlayAt0();
        assertEquals(2, game.getCurrentPlayer());
        game.play(0);
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test03oPlaysAt00() {
        Linea game = new Linea(4, 4, 'C');
        game.playBlueAt(0);
        assertEquals(2, game.getPlayerAt(3, 0));
    }

    @Test
    public void test04finishedWorks() {
        Linea game = new Linea(4, 4, 'C');
        assertFalse(game.isFinished());
        IntStream.range(0, 4)
            .forEach(j -> IntStream.range(j, 4)
                .forEach(i -> game.playRedAt(j)));
        assertTrue(game.isFinished());
    }

    @Test
    public void test05CanNotPlayAfterGameIsFinished() {
        Linea game = new Linea(4, 4, 'C');
        IntStream.range(0, 4)
            .forEach(j -> IntStream.range(j, 4)
                .forEach(i -> game.playRedAt(j)));
        game.playRedAt(0);
        assertEquals(0, game.getPlayerAt(3, 0));
    }
    @Test
    public void test06winWorksOnAnySizeBoard() {
        Linea game = diagonalWin('C');
        assertTrue(game.checkWin(1));
    }
    @Test
    public void test07DrawWorksIfNoneWins() {
        Linea game = diagonalWin('A');

        IntStream.range(0, 4)
            .forEach(i -> IntStream.range(0, 4)
                .forEach(j -> game.playRedAt(j)));
        assertTrue(game.isFinished());
        assertTrue(game.isDraw());
    }
    @Test public void test08GameModeAAcceptsVerticalWin() {
        Linea game = verticalWin('A');
        assertTrue(game.checkWin(1));
    }
    @Test public void test09GameModeAAcceptsHorizontalWin() {
        Linea game = horizontalWin('A');
        assertTrue(game.checkWin(1));
    }
    @Test
    public void test10GameModeBAcceptsDiagonalWin() {
        Linea game = diagonalWin('B');
        assertTrue(game.checkWin(1));
    }
    @Test
    public void test11GameModeCAcceptsVerticalWin() {
        Linea game = verticalWin('C');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test12GameModeCAcceptsHorizontalWin() {
        Linea game = horizontalWin('C');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test13GameModeCAcceptsDiagonalWin() {
        Linea game = diagonalWin('C');
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test14GameModeADoesNotAcceptDiagonalWins() {
        Linea game = diagonalWin('A');
        assertFalse(game.isFinished());
    }

    @Test
    public void test15GameModeBDoesNotAcceptHorizontalWin() {
        Linea game = horizontalWin('B');
        assertFalse(game.checkWin(1));
    }
    @Test public void test16GameModeBDoesNotAcceptVerticalWin() {
        Linea game = verticalWin('B');
        assertFalse(game.checkWin(1));
    }

    private Linea newGamePlayAt0() {
        Linea game = new Linea(4, 4, 'C');
        game.play(0);
        return game;
    }

    private Linea verticalWin( char gameMode ) {
        Linea game = new Linea(4, 4, gameMode);
        game.playRedAt(0);
        game.playRedAt(0);
        game.playRedAt(0);
        game.playRedAt(0);
        return game;
    }

    private Linea horizontalWin( char gameMode ) {
        Linea game = new Linea(4, 4, gameMode);
        game.playRedAt(0);
        game.playRedAt(1);
        game.playRedAt(2);
        game.playRedAt(3);
        return game;
    }

    private Linea diagonalWin( char gameMode ) { // TODO: try making this with a loop
        Linea game = new Linea(4, 4, gameMode);
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playBlueAt(3);
        game.playBlueAt(3);
        game.playRedAt(3);
        return game;
    }
}