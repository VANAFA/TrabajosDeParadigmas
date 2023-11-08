package linea;

import linea.gameModes.*;
import linea.gameStates.*;
import java.util.ArrayList;
import java.util.Collections;
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

        board = IntStream.range(0, height)
            .mapToObj(i -> IntStream.range(0, base)
                .mapToObj(j -> 0)
                .collect(Collectors.toCollection(ArrayList::new)))
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public String show() {
        String result = "█";
    
        result += IntStream.range(0, height)
                .mapToObj(i -> IntStream.range(0, base)
                        .mapToObj(j -> board.get(i).get(j) == 0 ? " -" : board.get(i).get(j) == 1 ? " X" : " O")
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" █\n█", "", " █\n█"));
    
        result += IntStream.range(0, base)
                .mapToObj(i -> " ^")
                .collect(Collectors.joining());
    
        result += " █\n█";
    
        result += IntStream.range(0, base)
                .mapToObj(i -> " " + (i))
                .collect(Collectors.joining());
    
        result += " █";
    
        if (finished()) { // TODO: Este if es válido
            result += " \n";
            if (checkWin(1)) {
                result += " X wins!";
            } else if (checkWin(2)) {
                result += " O wins!";
            } else {
                result += " It's a Draw!";
            }
        }
        return result;
    }
    
    public void playRedAt(int col) {
        currentState.playRed(col);
    }
    
    public void playBlueAt(int col) {
        currentState.playBlue(col);
    }

    public boolean finished() {
        return checkWin(1) || checkWin(2) || isDraw();
    }

    public boolean isDraw() {
        int moves = board.stream()
            .mapToInt(row -> row.stream()
                .mapToInt(i -> i)
                .sum())
            .sum();

        return moves >= base * height;
    }
    
    public boolean checkWin(int player) {
        GameMode[] modes = {new GameModeA(this), new GameModeB(this), new GameMode(this)};
        
        return modes[ gameMode - 'a' ].checkWin(player);
    }    
    
    public State getCurrentPlayer() {
        return currentState;
    }

    public int getPlayerAt(int row, int col) {
        return board.get(row).get(col);
    }

    public int getGameMode() {
        return gameMode;
    }
}