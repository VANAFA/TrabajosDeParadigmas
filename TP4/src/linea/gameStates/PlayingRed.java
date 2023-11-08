package linea.gameStates;

import linea.Linea;

public class PlayingRed extends State {

    public PlayingRed(Linea game) {
        super(game);
    }

    public void playRed(int col) {
        play(col, 1);
    }
    
    public void playBlue(int col) {
        throw new RuntimeException("No se puede jugar en el turno del otro jugador");
    }
}
