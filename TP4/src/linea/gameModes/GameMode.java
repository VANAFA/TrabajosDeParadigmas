package linea.gameModes;

import linea.Linea;
import java.util.stream.IntStream;

public class GameMode {

    private Linea game;

    public GameMode( Linea game ) {
        this.game = game;
    }

    public boolean checkWin(int player) {
        return horizontalVerticalWin( player ) || diagonalWin( player );
    }

    public boolean horizontalVerticalWin( int player ) {

        boolean horizontalWin = IntStream.range(0, game.height)
            .anyMatch(i -> IntStream.range(0, game.base - 3)
                .anyMatch(j -> IntStream.range(j, j + 4)
                    .allMatch(k -> game.board.get(i).get(k) == player)));

        boolean verticalWin = IntStream.range(0, game.base)
            .anyMatch(i -> IntStream.range(0, game.height - 3)
                .anyMatch(j -> IntStream.range(j, j + 4)
                    .allMatch(k -> game.board.get(k).get(i) == player)));

        return horizontalWin || verticalWin;
    }

    protected boolean diagonalWin( int player ) { // TODO: usar lo del tablero fantasma comienzo en el 0,0 menos la base con xy, y la inversa para la otra diagonal -xy. O ver si lo que está hecho está bueno usarlo

        boolean diagonalWin = IntStream.range(0, game.height - 3)
            .anyMatch(i -> IntStream.range(0, game.base - 3)
                .anyMatch(j -> IntStream.range(0, 4)
                    .allMatch(k -> game.board.get(i + k).get(j + k) == player)));

        boolean diagonalWin2 = IntStream.range(0, game.height - 3)
            .anyMatch(i -> IntStream.range(0, game.base - 3)
                .anyMatch(j -> IntStream.range(0, 4)
                    .allMatch(k -> game.board.get(i + k).get(game.base - j - k - 1) == player)));

        return diagonalWin || diagonalWin2;
    }
}