package chapter3;

public class ScoreBoard {
    private int numEntries = 0;
    private GameEntry[] board;

    /**
     * Constructs an empty scoreboard with the given capacity for storing entries.
     */
    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) numEntries++;
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) throw new IndexOutOfBoundsException("Invalid index " + i);
        GameEntry temp = board[i];
        while (i < numEntries - 1) {
            board[i] = board[i + 1];
            i++;
        }
        board[numEntries - 1] = null;
        numEntries--;

        /*
        for (int j = i; j < numEntries-1; j++){
            board[j] = board[j + 1];
        }
        board[numEntries-1] = null;
        //   i++;
        numEntries--;
        */
        return temp;
    }

    public int getNumEntries() {
        return numEntries;
    }

    public void setNumEntries(int numEntries) {
        this.numEntries = numEntries;
    }

    public GameEntry[] getBoard() {
        return board;
    }

    public void setBoard(GameEntry[] board) {
        this.board = board;
    }
}
