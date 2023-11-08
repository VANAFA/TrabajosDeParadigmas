package linea.gameStates;

import linea.Linea;

public class BlueWon extends State {
    
    public BlueWon(Linea game) {
        super(game);
    }

    public void playRed(int col) {
        throw new RuntimeException("Game over");
    }

    public void playBlue(int col) {
        throw new RuntimeException("Game over");
    }
}
