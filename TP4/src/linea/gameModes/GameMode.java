package linea.gameModes;

import linea.Linea;

import java.util.List;
import java.util.stream.IntStream;

public class GameMode {

    private Linea game;

    public GameMode( Linea game ) {
        this.game = game;
    }

    public boolean checkWin(int player) {
        return horizontalVerticalWin( player ) || diagonalWin( player );
    }

    protected boolean horizontalVerticalWin( int player ) {
        
        for (int i = 0; i < game.height; i++) { // TODO: replace the fors
            for (int j = 0; j < game.base - 3; j++) {
                if (game.safeGet(i, j) == player && game.safeGet(i, j + 1) == player && game.safeGet(i, j + 2) == player && game.safeGet(i, j + 3) == player) {
                    return true;
                }
            }
        }
        for (int i = 0; i < game.base; i++) {
            for (int j = 0; j < game.height - 3; j++) {
                if (game.safeGet(i, j) == player && game.safeGet(i, j + 1) == player && game.safeGet(i, j + 2) == player && game.safeGet(i, j + 3) == player) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean diagonalWin(int player) {

        for (int i = 0; i < game.height - 3; i++) {
            for (int j = 0; j < game.base - 3; j++) {
                if (game.safeGet(i, j) == player && game.safeGet(i + 1, j + 1) == player && game.safeGet(i + 2, j + 2) == player && game.safeGet(i + 3, j + 3) == player) {
                    return true;
                }
            }
        }
        for (int i = 0; i < game.height - 3; i++) {
            for (int j = 3; j < game.base; j++) {
                if (game.safeGet(i, j) == player && game.safeGet(i + 1, j - 1) == player && game.safeGet(i + 2, j - 2) == player && game.safeGet(i + 3, j - 3) == player) {
                    return true;
                }
            }
        }
        return false;
    }
}