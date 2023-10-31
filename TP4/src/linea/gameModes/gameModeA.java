package linea.gameModes;

import linea.Linea;

public class GameModeA extends GameMode {
    
    public GameModeA( Linea game ) {
        super(game);
    }

    @Override
    public boolean checkWin( int player ) {
        return horizontalVerticalWin( player );
    }
}
