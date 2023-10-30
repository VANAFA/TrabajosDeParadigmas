package linea;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineaTest {

    @Test
    public void test00baseSizeCanNotBeLessThan4() {
        assertThrows( IllegalArgumentException.class, () -> new Linea(3, 5, 'A') );
    }

    @Test 
    public void test01heightSizeCanNotBeLessThan4() {
        assertThrows( IllegalArgumentException.class, () -> new Linea(5, 3, 'A') );
    }

    @Test
    public void test02gameModeCanNotBeInvalid() {
        assertThrows( IllegalArgumentException.class, () -> new Linea(5, 5, 'D') );
    }

    @Test
    public void test03xStartsPlaying() {
        Linea game = new Linea(5, 5, 'A');
        assertEquals(1, game.getCurrentPlayer());
    }

    @Test
    public void test04xPlaysAt00() {
        Linea game = new Linea(5, 5, 'A');
        game.play(0, 0);
        assertEquals(1, game.getBoard()[0][0]);
    }

    @Test
    public void test05oPlaysAt00() {
        Linea game = new Linea(5, 5, 'A');
        game.play(0, 0);
        game.switchPlayer();
        game.play(0, 1);
        assertEquals(2, game.getBoard()[0][1]);
    }

    @Test
    public void test06verticalWinWorks() {
        
    }

}