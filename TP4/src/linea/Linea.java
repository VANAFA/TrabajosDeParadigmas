package linea;


public class Linea {
    
    private int[][] board = new int[4][4];
    private int currentPlayer = 1;
    private int moves = 0;

    public Linea (int base, int height, char gameMode) { // char is gameMode, A == only horizontal or veticla win. B == only diagonal win. C == both
        if (base < 1 || base > 4 || height < 1 || height > 4) {
            throw new IllegalArgumentException("Invalid dimensions");
        }
        if (gameMode != 'A' && gameMode != 'B' && gameMode != 'C') {
            throw new IllegalArgumentException("Invalid game mode");
        }
        if (gameMode == 'A') {
            if (base != 1 && height != 1) {
                throw new IllegalArgumentException("Invalid dimensions");
            }
        }
        if (gameMode == 'B') {
            if (base != 1 && height != 1) {
                throw new IllegalArgumentException("Invalid dimensions");
            }
        }
        if (gameMode == 'C') {
            if (base != 1 && height != 1) {
                throw new IllegalArgumentException("Invalid dimensions");
            }
        }
    }

    public boolean play(int row, int col) {
        if (board[row][col] != 0) {
            return false;
        }
        board[row][col] = currentPlayer;
        moves++;
        return true;
    }

    public boolean checkWin(int player) {
        // Check rows
        for (int i = 0; i < 4; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player && board[i][3] == player) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 4; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player && board[3][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player && board[3][3] == player) {
            return true;
        }
        if (board[0][3] == player && board[1][2] == player && board[2][1] == player && board[3][0] == player) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        return moves == 16;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int[][] getBoard() {
        return board;
    }

    // New methods added
    public boolean finished() {
        return checkWin(1) || checkWin(2) || isDraw();
    }

    public void playRedAt(int col) {
        int row = 0;
        while (row < 4 && board[row][col] != 0) {
            row++;
        }
        if (row < 4) {
            play(row, col);
            switchPlayer();
        }
    }

    public void playBlueAt(int col) {
        int row = 0;
        while (row < 4 && board[row][col] != 0) {
            row++;
        }
        if (row < 4) {
            play(row, col);
            switchPlayer();
        }
    }

    public String show() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += board[i][j] == 0 ? "." : board[i][j] == 1 ? "X" : "O";
            }
            result += "\n";
        }
        return result;
    }
}