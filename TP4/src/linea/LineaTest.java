package linea;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineaTest { // al final que ordenar los test y ponerle los números correctos

    @Test
    public void test01xStartsPlaying() {
        Linea game = new Linea(5, 5, 3);
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test02xPlaysAt00() {
        Linea game = new Linea(5, 5, 3);
        game.playRedAt(1);
        assertEquals(1, game.getPosition()[0][0]);// TODO:arreglar el get position
    }

    @Test
    public void test03oPlaysAt00() {
        Linea game = new Linea(5, 5, 3);
        game.playRedAt(1);
        assertEquals(1, game.getPosition()[0][0]);
    }

    @Test
    public void test06verticalWinWorks() {
        Linea game = new Linea(5, 5, 3);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        assertTrue(game.checkWin(1));
    }

    @Test
    public void test07horizontalWinWorks() {
        Linea game = new Linea(5, 5, 3);
        game.playRedAt(1);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(2);
        game.playRedAt(3);
        game.playBlueAt(3);
        game.playRedAt(4);
        assertTrue(game.checkWin(1));
        }       

    @Test
    public void test08diagonalWinWorks() {
        Linea game = new Linea(5, 5, 3);
        diagonalWin(game);
        assertTrue(game.checkWin(1));
    }


    @Test
    public void test09winWorksOnAnySizeBoard() {
        Linea game = new Linea(8, 5, 3);
        diagonalWin(game);
        assertTrue(game.checkWin(1));

    }

    @Test
    public void test10DrawWorksIfNoneWins4x4() {
        Linea game = new Linea(4, 4, 1);
        
        diagonalWin( game );
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(2);
        game.playBlueAt(1);

        assertTrue(game.isDraw());
    }

    @Test
    public void test11GameModeADoesNotAcceptDiagonalWins() {
        Linea game = new Linea(5, 5, 1);
        diagonalWin(game);
        assertFalse(game.checkWin(1));
    }

    @Test
    public void test12GameModeBOnlyDiagonalWin() {
        Linea game = new Linea(5, 5, 2);
        diagonalWin(game);
        assertTrue(game.checkWin(1));
    }

    private void diagonalWin( Linea game ) {
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(1);
        game.playRedAt(4);
    }
}