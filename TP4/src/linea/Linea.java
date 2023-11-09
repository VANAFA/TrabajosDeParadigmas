package linea;

import linea.gameModes.*;
import linea.gameStates.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TODO: sólo usar geters en tests

public class Linea { // al final que ordenar el código
    
    public ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    public State currentState = new PlayingRed( this );
    public int base;
    public int height;
    private int gameMode;
    
    public Linea(int base, int height, int gameMode) {
        this.base = base;
        this.height = height;
        this.gameMode = Character.toLowerCase(gameMode);

        for (int i = 0; i < height; i++) {
            board.add(new ArrayList<Integer>());
        } // TODO: replce the for for a stream
    }
    
    public String show() {
        // the show should look like this:
        // █ - - - - █
        // █ - X O X █
        // █ X O X O █
        // █ O X X O █
        // █ ^ ^ ^ ^ █
        // █ 0 1 2 3 █

        String result = "";

        result += IntStream.range(0, height)
            .mapToObj(j -> {
                String row = "█ ";
                row += IntStream.range(0, base)
                    .mapToObj(i -> {
                        int player = safeGet(i, j);
                        if (player == 0) {
                            return "- ";
                        } else if (player == 1) {
                            return "X ";
                        } else {
                            return "O ";
                        }
                    })
                    .collect(Collectors.joining());
                row += "█\n";
                return row;
            })
            .collect(Collectors.joining());

        result += "█";
        result += IntStream.range(0, base)
            .mapToObj(i -> " ^")
            .collect(Collectors.joining());
        result += " █\n";

        result += "█";
        result += IntStream.range(0, base)
            .mapToObj(i -> " " + i)
            .collect(Collectors.joining());
        result += " █\n";
    
        currentState.show(); // this isnt working

        // if (finished()) {
        //     result += " \n";
        //     if (checkWin(1)) {
        //         result += " X wins!";
        //     } else if (checkWin(2)) {
        //         result += " O wins!";
        //     } else {
        //         result += " It's a Draw!";
        //     }
        // }

        return result;
    }
    
    public void playRedAt(int col) {
        currentState.playRed(col);
    }
    
    public void playBlueAt(int col) {
        currentState.playBlue(col);
    }

    public boolean finished() {
        return currentState.isFinished();
    }

    public boolean isDraw() {
        int moves = board.stream()
            .mapToInt(List::size)
            .sum();

        return moves >= base * height;
    }
    
    public boolean checkWin(int player) {
        GameMode[] modes = {new GameModeA(this), new GameModeB(this), new GameMode(this)};
        
        return modes[ gameMode - 'a' ].checkWin(player);
    }    

    public int safeGet(int i, int j) {
        if (i >= 0 && i < board.size()) {
            List<Integer> row = board.get(i);
            if (j >= 0 && j < row.size()) {
                return row.get(j);
            }
        }
        return 0;
    }
    
    public State getCurrentPlayer() {
        return currentState;
    }
    
    public int getPlayerAt(int row, int col) {
        return safeGet(col, row);
    }

    public int getGameMode() {
        return gameMode;
    }
}