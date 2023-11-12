package linea.gameStates;

import linea.Linea;

public class State {

    protected Linea game;

    public State(Linea game) {
        this.game = game;
    }

    public void playRed(int col) {
        throw new RuntimeException("Invalid turn");
    }
    
    public void playBlue(int col) {
        throw new RuntimeException("Invalid turn");
    }
    
    protected void play(int col, int player) {
        if (col >= 0 && col < game.base) {
            game.board.get(col).add(player);
        } else {
            throw new RuntimeException("No se puede jugar en esa columna");
        }
    }
    
    public boolean isFinished() {
        return true;
    }
    
    public String getResult(String result) {
        return result;
    }
}