package linea.gameStates;

import linea.Linea;

public class PlayingBlue extends State {

    public PlayingBlue(Linea game) {
        super(game);
    }

    public void playRed(int col) {
        throw new RuntimeException("No se puede jugar en el turno del otro jugador");
    }

    public void playBlue(int col) {
        play(col, 2);
        if (game.checkWin(2)) { // TODO: get rid of the if statement
            game.currentState = new RedWon(game);
        } else if (game.finished()) {
            game.currentState = new Draw(game);
        } else {
            game.currentState = new PlayingBlue(game);
        }
    }
}
