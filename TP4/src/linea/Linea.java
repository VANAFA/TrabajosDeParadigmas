package linea;


public class Linea {
    
    private int[][] board = new int[10][10]; // hardcoded
    private int currentPlayer = 1;
    private int moves = 0;
    private int base;
    private int height;

    // no hacer una clase board ni una clase ficha, pero hay que aplicar polimorfismo

    public Linea (int base, int height, char gameMode) { // char is gameMode, A == only horizontal or veticla win. B == only diagonal win. C == both
        this.base = base;
        this.height = height;

        if (base < 4 || height < 4) {
            throw new IllegalArgumentException("Invalid dimensions");
        }
        if (gameMode != 'A' && gameMode != 'B' && gameMode != 'C') {
            throw new IllegalArgumentException("Invalid game mode");
        }
        // make a way to set the game mode
    }

    public boolean checkWin(int player) {
        // Check rows
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= base - 4; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i][j+k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        // Check columns
        for (int i = 0; i <= height - 4; i++) {
            for (int j = 0; j < base; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i+k][j] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        // Check diagonals
        for (int i = 0; i <= height - 4; i++) {
            for (int j = 0; j <= base - 4; j++) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i+k][j+k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        for (int i = 0; i <= height - 4; i++) {
            for (int j = base - 1; j >= 3; j--) {
                boolean win = true;
                for (int k = 0; k < 4; k++) {
                    if (board[i+k][j-k] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDraw() { // moves should be equal to the number of empty spaces
        return moves == (base - 2) * (height - 2);
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

    // New methods added
    public boolean isFinished() { // this returns true if the game is finished
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
        if ( col > 0 && col < base) {
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
        for (int i = 0; i < base; i++) {
            result += " " + (i+1);
        }
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