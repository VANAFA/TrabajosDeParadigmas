package linea.gameStates;

import linea.Linea;

public abstract class State {

    protected Linea game;

    public State(Linea game) {
        this.game = game;
    }

    abstract public void playRed(int col);
    abstract public void playBlue(int col);
    
    public boolean isFinished() {
        return true;
    }

    protected void play(int col, int player) {
        if (col >= 0 && col < game.base && !game.finished()) {
            game.board.get(col).add(player);
        } else {
            throw new RuntimeException("No se puede jugar en esa columna");
        }
    }
}