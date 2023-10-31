package linea.gameModes;

import linea.Linea;

public class GameMode {

    protected Linea game;

    public GameMode( Linea game ) {
        this.game = game;
    }

    public boolean checkWin(int player) {
        // Check rows
        for (int i = 0; i < game.height; i++) {
            for (int j = 0; j <= game.base - 4; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (game.board[i][j+k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        // Check columns
        for (int i = 0; i <= game.height - 4; i++) {
            for (int j = 0; j < game.base; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (game.board[i+k][j] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        // Check diagonals
        for (int i = 0; i <= game.height - 4; i++) {
            for (int j = 0; j <= game.base - 4; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (game.board[i+k][j+k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        for (int i = 0; i <= game.height - 4; i++) {
            for (int j = game.base - 1; j >= 3; j--) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (game.board[i+k][j-k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
}
