package linea;

import linea.gameModes.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Linea {
    
    public ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(); // ArrayList of ArrayLists
    public int base;
    public int height;
    private int gameMode;
    private int currentPlayer = 1;
    private int moves;

    // pedir que una columna sea positiva puede tener un if
    // es el turno correcto?, ganó? estoy usando la estrategia correcta? esto puede usar if

    // Podemos tener un arraylist con arraylist adentro

    // no hacer una clase board ni una clase ficha, pero hay que aplicar polimorfismo. Done

    // no hay que dar un error en un tablero inganable. Done
    
    public Linea (int base, int height, int gameMode) {
        this.base = base;
        this.height = height;
        this.gameMode = gameMode;
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < base; j++) {
                row.add(0);
            }
            board.add(row);
        }
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
                .mapToObj(i -> " " + (i+1))
                .collect(Collectors.joining());
    
        result += " █";
    
        if (isFinished()) { // TODO: preguntar si estos if son válidos, pero creo que sí
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
    
    public void playRedAt(int col) {
        play(col);
    }
    
    public void playBlueAt(int col) {
        play(col);
    }
    
    public void play(int col) {
        int row = base - 1;
        while (row >= 0 && board.get(row).get(col) != 0) {
            row--;
        }
        if (row >= 0 && col >= 0 && row < height && col < base) {
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

    public int getCurrentPlayer() { // TODO: preguntar si es necesario este método
        return currentPlayer;
    }

    public ArrayList<ArrayList<Integer>> getPosition() {
        return board;
    }
}