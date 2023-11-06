package linea;

import java.util.ArrayList;
import java.util.Random;

public class PlayerTwo {
    private Linea game;

    public PlayerTwo(Linea game) {
        this.game = game;
    }

    public void play() {
        int col = findWinningMove();
        if (col == -1) {
            col = findCounterMove();
        }
        game.playBlueAt(col);
    }

    private int findWinningMove() {
        for (int col = 0; col < game.base; col++) {
            Linea copy = new Linea(game.base, game.height, game.getGameMode());
            copy.board = new ArrayList<>();
            for (ArrayList<Integer> row : game.board) {
                copy.board.add(new ArrayList<>(row));
            }
            copy.playBlueAt(col);
            if (copy.checkWin(2)) {
                return col;
            }
        }
        return -1;
    }

    private int findCounterMove() {
        for (int col = 0; col < game.base; col++) {
            Linea copy = new Linea(game.base, game.height, game.getGameMode());
            copy.board = new ArrayList<>();
            for (ArrayList<Integer> row : game.board) {
                copy.board.add(new ArrayList<>(row));
            }
            copy.playRedAt(col);
            if (copy.checkWin(1)) {
                return col;
            }
        }
        return randomMove();
    }

    private int randomMove() {
        Random random = new Random();
        int col = random.nextInt(game.base);
        while (game.board.get(0).get(col) != 0) {
            col = random.nextInt(game.base);
        }
        return col;
    }
}