package linea;

import java.util.Random;

public class PlayerTwo {

    private final Linea game;
    private final Random random;

    public PlayerTwo(Linea game) {
        this.game = game;
        this.random = new Random();
    }

    public void play() {
        int col = chooseColumn();
        game.playBlueAt(col);
    }

    private int chooseColumn() {
        int col = random.nextInt(game.base);
        while (game.safeGet(0, col) != 0) {
            col = random.nextInt(game.base);
        }
        return col;
    }
}
