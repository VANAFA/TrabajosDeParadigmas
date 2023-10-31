package linea;

import linea.gameModes.*;
import linea.size.*;

public class Linea {
    
    public int base;
    public int height;
    public int[][] board = new int[10][10]; // hardcoded
    private int currentPlayer = 1;
    private int moves = 0;
    private int gameMode;

    // no hacer una clase board ni una clase ficha, pero hay que aplicar polimorfismo

    public Linea (int base, int height, int gameMode) {
        this.base = base;
        this.height = height;
        this.gameMode = gameMode;

        Size[] sizes = {new InvalidSize(), new Size()};
        // Size size = 

        // if (base < 4 || height < 4) {
        //     throw new IllegalArgumentException("Invalid dimensions");
        // }

        // if (gameMode < 1 || gameMode > 3) {
        //     throw new IllegalArgumentException("Invalid game mode");
        // }
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

    public int[][] getBoard() {
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

    public String show() {
        String result = "█";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                result += board[i][j] == 0 ? " -" : board[i][j] == 1 ? " X" : " O"; // this is an if statement
            }
            result += " █\n█";
        }
        for (int i = 0; i < base; i++) {
            result += " ^";
        }
        result += " █\n█";
        // for (int i = 0; i < base; i++) {
        //     result += " " + (i+1);
        // } this has an unexpected behaviour when base is greater than 9
        result += " █";
        if (isFinished()) {
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
}