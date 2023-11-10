package linea;

import linea.gameModes.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
    
    public ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(); // Esto es válido
    public int base;
    public int height;
    private int currentPlayer = 1;
    private int moves;
    private int gameMode;

    // es el turno correcto?, ganó? estoy usando la estrategia correcta? esto puede usar if
    
    public Linea (int base, int height, int gameMode) {
    this.base = base;
    this.height = height;
    this.gameMode = gameMode;
    
    board = IntStream.range(0, height) // TODO: make this simpler
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
    
        if (isFinished()) { // Este if es válido
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
    
    public boolean checkWin(int player) {
        GameMode[] modes = {new GameModeA(this), new GameModeB(this), new GameMode(this)};
        
        return modes[ gameMode - 'A' ].checkWin(player);
    }
    
    public void playRedAt(int col) {
        currentPlayer = 1;
        play(col);
    }
    
    public void playBlueAt(int col) {
        currentPlayer = 2;
        play(col);
    }
    
    public void play(int col) {
        int row = height - 1;
        while (row >= 0 && board.get(row).get(col) != 0) {
            row--;
        }
        if (row >= 0 && col >= 0 && row < height && col < base && !isFinished()) { // Esto es válido
            board.get(row).set(col, currentPlayer);
            moves++;
        }
        switchPlayer();
    }
    
    public void switchPlayer() {
        currentPlayer = currentPlayer % 2 + 1;
    }

    public boolean isFinished() {
        return checkWin(1) || checkWin(2) || isDraw();
    }

    public boolean isDraw() {
        return moves == base * height;
    }

    public int getCurrentPlayer() { // Tenemos que tener los getters
        return currentPlayer;
    }

    public int getPlayerAt(int row, int col) {
        return board.get(row).get(col);
    }

    public int getGameMode() {
        return gameMode;
    }
}