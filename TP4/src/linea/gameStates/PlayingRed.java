package linea.gameStates;

import linea.Linea;

public class PlayingRed extends State {

    public PlayingRed(Linea game) {
        super(game);
    }

    public void playRed(int col) {

        play(col, 1);
        game.currentState = new PlayingBlue(game);

        if (game.checkWin(1)) { // TODO: preguntar por este if
            game.currentState = new RedWon(game);
        } else if (game.isDraw()) {
            game.currentState = new Draw(game);
        }
    }
    
    public void playBlue(int col) {
        throw new RuntimeException("No se puede jugar en el turno del otro jugador");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
