package linea.gameModes;

import linea.Linea;

import java.util.List;
import java.util.stream.*;

public class GameMode {

    private Linea game;

    public GameMode( Linea game ) {
        this.game = game;
    }

    public boolean checkWin(int player) {
        return horizontalVerticalWin( player ) || diagonalWin( player );
    }

    protected boolean horizontalVerticalWin( int player ) {
        
        List<Integer> rows = IntStream.range(0, game.height).boxed().collect(Collectors.toList());
        List<Integer> cols = IntStream.range(0, game.base - 3).boxed().collect(Collectors.toList());
        
        return rows.stream().anyMatch(i -> cols.stream().anyMatch(j -> winCheckerIn(player, i, j, 0, 1)))
                || cols.stream().anyMatch(j -> rows.stream().anyMatch(i -> winCheckerIn(player, i, j, 1, 0)));
    }

    protected boolean diagonalWin(int player) {

        List<Integer> rows = IntStream.range(0, game.height - 3).boxed().collect(Collectors.toList());
        List<Integer> cols1 = IntStream.range(0, game.base - 3).boxed().collect(Collectors.toList());
        List<Integer> cols2 = IntStream.range(3, game.base).boxed().collect(Collectors.toList());

        return rows.stream().anyMatch(i -> cols1.stream().anyMatch(j -> winCheckerIn(player, i, j, 1, 1)))
                || rows.stream().anyMatch(i -> cols2.stream().anyMatch(j -> winCheckerIn(player, i, j, 1, -1)));
    }
    
    private boolean winCheckerIn(int player, int i, int j, int addi, int addj) {
        return game.safeGet(i, j) == player && game.safeGet(i + addi, j + addj) == player && game.safeGet(i + addi + 1 * addi, j + addj + 1 * addj) == player && game.safeGet(i + addi + 2 * addi, j + addj + 2 * addj) == player;
    }
}