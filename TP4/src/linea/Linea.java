package linea;

import linea.gameModes.*;
import linea.gameStates.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea { // al final que ordenar el código
    
    private int gameMode;
    public ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
    public State currentState = new PlayingRed( this );
    public int base;
    public int height;
    
    public Linea(int base, int height, int gameMode) {
        this.base = base;
        this.height = height;
        this.gameMode = Character.toLowerCase(gameMode);
        
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Height and base must be greater than 0.");
        }
        
        board = IntStream.range(0, height)
                         .mapToObj(i -> new ArrayList<Integer>())
                         .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public String show() {
        
        String result = "";
        
        result += IntStream.range(0, height)
                           .mapToObj(i -> "█ " + IntStream.range(0, base)
                                                          .mapToObj(j -> {
                                                            int player = safeGet(j, height - 1 - i);
                                                            if (player == 0) {
                                                                return "- ";
                                                            } else if (player == 1) {
                                                                return "X ";
                                                            } else {
                                                                return "O ";
                                                            }
                                                        })
                                                          .collect(Collectors.joining()) + "█\n")
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

        return currentState.getResult(result);
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
                         .mapToInt(ArrayList::size)
                         .sum();

        return moves >= base * height;
    }
    
    public boolean checkWin(int player) {
        GameMode[] modes = {new GameModeA(this), new GameModeB(this), new GameMode(this)};
        
        return modes[ gameMode - 'a' ].checkWin(player);
    }    

    public int safeGet(int i, int j) { // TODO: revise if this can be done without if statements
        if (i >= 0 && i < board.size()) {
            ArrayList<Integer> row = board.get(i);
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