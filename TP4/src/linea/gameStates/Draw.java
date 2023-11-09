package linea.gameStates;

import linea.Linea;

public class Draw extends State {
    
    public Draw(Linea game) {
        super(game);
    }

    public void playRed(int col) {
        throw new RuntimeException("Game over");
    }

    public void playBlue(int col) {
        throw new RuntimeException("Game over");
    }

    @Override
    public void show() {
        System.out.println("It's a draw!");
    }
}
