package linea.gameStates;

import linea.Linea;

public class PlayingRed extends State {

    public PlayingRed(Linea game) {
        super(game);
    }

    public void playRed(int col) {
        play(col, 1);
        // here, set the state to PlayingBlue or if red won set it to red won or if draw set it to draw. but dont use if statement
        if (game.checkWin(1)) { // TODO: get rid of the if statement
            game.currentState = new RedWon(game);
        } else if (game.finished()) {
            game.currentState = new Draw(game);
        } else {
            game.currentState = new PlayingBlue(game);
        }
    }
    
    public void playBlue(int col) {
        throw new RuntimeException("No se puede jugar en el turno del otro jugador");
    }
}
