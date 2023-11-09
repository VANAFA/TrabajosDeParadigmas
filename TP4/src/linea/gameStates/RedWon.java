package linea.gameStates;

import linea.Linea;

public class RedWon extends State {
    
    public RedWon(Linea game) {
        super(game);
    }

    public void playRed(int col) {
        throw new RuntimeException("Game over, red won");
    }

    public void playBlue(int col) {
        throw new RuntimeException("Game over, red won");
    }

    @Override
    public void show() {
        System.out.println("Red won!");
    }
}
