package linea.gameModes;

import linea.Linea;

public class GameModeB extends GameMode {
    
    public GameModeB( Linea game ) {
        super(game);
    }

    @Override
    public boolean checkWin( int player ) {
       return diagonalWin( player );
    }
}