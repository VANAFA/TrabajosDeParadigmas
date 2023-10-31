package linea.gameModes;

import linea.Linea;

public class gameModeA extends GameMode {
    
    public gameModeA( Linea game ) {
        super(game);
    }

    @Override
    public boolean checkWin(int player) {
        // Check rows
        for (int i = 0; i < game.height; i++) {
            for (int j = 0; j <= game.base - 4; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    win &= game.board[i][j+k] == player;
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
                    win &= game.board[i+k][j] == player;
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
}
