package linea;

import org.junit.Test;
import java.util.stream.IntStream;
import static org.junit.Assert.*;

public class LineaTest { // al final que ordenar los test y ponerle los números correctos

    @Test
    public void test01xStartsPlaying() {
        Linea game = new Linea(5, 5, 'c');
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test02xPlaysAt00() {
        Linea game = new Linea(4, 4, 'c');
        game.playRedAt(0);
        assertEquals(1, game.getPlayerAt(3, 0));
    }

    @Test
    public void test03TurnsAreRespected() {
        Linea game = new Linea(4, 4, 'c');
        game.play(0);
        assertEquals(2, game.getCurrentPlayer());
        game.play(0);
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test03oPlaysAt00() {
        Linea game = new Linea(4, 4, 'c');
        game.playBlueAt(0);
        assertEquals(2, game.getPlayerAt(3, 0));
    }

    @Test
    public void test05finishedWorks() {
        Linea game = new Linea(4, 4, 'c');
        assertFalse(game.finished());
        IntStream.range(0, 4)
            .forEach(j -> IntStream.range(j, 4)
                .forEach(i -> game.playRedAt(j)));
        assertTrue(game.finished());
    }

    @Test
    public void test06CanNotPlayAfterGameIsFinished() {
        Linea game = new Linea(4, 4, 'c');
        IntStream.range(0, 4)
            .forEach(j -> IntStream.range(j, 4)
                .forEach(i -> game.playRedAt(j)));
        game.playRedAt(0);
        assertEquals(0, game.getPlayerAt(3, 0));
    }

    @Test
    public void test06verticalWinWorks() {
        Linea game = new Linea(5, 5, 'c');
        game.playRedAt(0);
        game.playRedAt(0);
        game.playRedAt(0);
        game.playRedAt(0);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test07horizontalWinWorks() {
        Linea game = new Linea(5, 5, 'c');
        game.playRedAt(1);
        game.playRedAt(2);
        game.playRedAt(3);
        game.playRedAt(4);
        assertTrue(game.checkWin(1));
    }       

    @Test
    public void test08diagonalWinWorks() {
        Linea game = new Linea(5, 5, 'c');
        diagonalWin(game);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test09winWorksOnAnySizeBoard() {
        Linea game = new Linea(8, 5, 'c');

        diagonalWin(game);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test10DrawWorksIfNoneWins4x4() {
        Linea game = new Linea(4, 4, 'a');
        
        diagonalWin( game );

        IntStream.range(0, 4)
            .forEach(j -> IntStream.range(j, 4)
                .forEach(i -> game.playBlueAt(j)));

        assertTrue(game.isDraw());
    }

    @Test
    public void test11GameModeADoesNotAcceptDiagonalWins() {
        Linea game = new Linea(5, 5, 'a');
        diagonalWin(game);
        assertFalse(game.finished());
    }

    @Test
    public void test12GameModeBOnlyDiagonalWin() {
        Linea game = new Linea(5, 5, 'b');
        diagonalWin(game);
        assertTrue(game.checkWin(1));
    }

    private void diagonalWin( Linea game ) { // TODO: try making this with a loop
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
    }
}