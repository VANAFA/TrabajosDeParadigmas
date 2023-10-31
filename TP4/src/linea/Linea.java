package linea;

import linea.gameModes.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Linea {
    
    public int base;
    public int height;
    public int[][] board = new int[10][10]; // hardcoded limit
    private int currentPlayer = 1;
    private int moves = 0;
    private int gameMode;

    // pedir que una columna sea positiva puede tener un if
    // es el turno correcto?, ganó? estoy usando la estrategia correcta? esto puede usar if

    // Podemos tener un arraylist con arraylist adentro

    // no hacer una clase board ni una clase ficha, pero hay que aplicar polimorfismo. Done

    // no hay que dar un error en un tablero inganable. Done
    
    public Linea (int base, int height, int gameMode) {
        this.base = base;
        this.height = height;
        this.gameMode = gameMode;
        
        if (gameMode < 1 || gameMode > 3) { // TODO: preguntar si hay que dar un error en un invalid gameMode
            throw new IllegalArgumentException("Invalid game mode");
        }
    }
    
        public String show() {
            String result = "█";
    
            result += IntStream.range(0, height)
                    .mapToObj(i -> IntStream.range(0, base)
                            .mapToObj(j -> board[i][j] == 0 ? " -" : board[i][j] == 1 ? " X" : " O")
                            .collect(Collectors.joining()))
                    .collect(Collectors.joining(" █\n█", "", " █\n█"));
    
            result += IntStream.range(0, base)
                    .mapToObj(i -> " ^")
                    .collect(Collectors.joining());
    
            result += " █\n█";
    
            result += IntStream.range(0, base)
                    .mapToObj(i -> " " + (i+1))
                    .collect(Collectors.joining());
    
            result += " █";
    
            if (isFinished()) { // estos if son válidos
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
        
        return modes[gameMode-1].checkWin(player);
    }

    public boolean isDraw() {
        return moves == base * height;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer % 2 + 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int[][] getPosition() {
        return board;
    }

    public boolean isFinished() {
        return checkWin(1) || checkWin(2) || isDraw();
    }

    public void playRedAt(int col) {
        int row = base - 1;
        while (row >= 0 && board[row][col-1] != 0) {
            row--;
        }
        if (row >= 0) {
            play(row, col-1);
            switchPlayer();
        }
    }

    public void playBlueAt(int col) {
        int row = base - 1;
        while (row >= 0 && board[row][col-1] != 0) {
            row--;
        }
        if (row >= 0) {
            play(row, col-1);
            switchPlayer();
        }
    }

    public void play(int row, int col) {
        board[row][col] = currentPlayer;
        if ( col >= 0 && col < base) {
            moves++;
        }
    }
}