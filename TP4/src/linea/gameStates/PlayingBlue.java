package linea.gameStates;

import linea.Linea;

public class PlayingBlue extends State {

    public PlayingBlue(Linea game) {
        super(game);
    }

    public void playBlue(int col) {

        play(col, 2);
        game.currentState = new PlayingRed(game);

        if (game.checkWin(2)) {
            game.currentState = new BlueWon(game);
        } else if (game.isDraw()) {
            game.currentState = new Draw(game);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
