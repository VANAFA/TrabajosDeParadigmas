package linea.gameStates;

import linea.Linea;

public abstract class State {

    protected Linea game;

    public State(Linea game) {
        this.game = game;
    }

    abstract public void playRed(int col);
    abstract public void playBlue(int col);

    protected void play(int col, int player) {
        int row = game.height - 1;
        col %= game.base;
        while (row >= 0 && game.board.get(row).get(col) != 0) {
            row--;
        }
        if (row >= 0 && col >= 0 && row < game.height && col < game.base && !game.finished()) { // TODO: Esto es válido. estos son los límites // esta verificación no hace falta si hago jugada mod base
            game.board.get(row).set(col, player);
        }
    }
}