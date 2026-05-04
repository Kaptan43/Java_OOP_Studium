package uebung04.chess;

import static java.lang.Integer.signum;
import static java.lang.Math.abs;

public class Queen implements Piece {
    private final Color color;
    private final Board board;
    private final int row;
    private final int col;

    public Queen(Color color, Board board, int row, int col) {
        if (row < 1 || row > 8 || col < 1 || col > 8)
            throw new IllegalArgumentException("Invalid pos " + row + "/" + col);
        this.color = color;
        this.board = board;
        this.row = row;
        this.col = col;
        board.add(this);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public char charRep() {
        return color == Color.white ? 'q' : 'Q';
    }

    @Override
    public String toString() {
        return color + " queen at (" + row + ", " + col + ")";
    }

    @Override
    public boolean canCapture(Piece other) {
        if (board != other.getBoard() || color == other.getColor())
            return false;
        if (other.getRow() != row &&
            other.getCol() != col &&
            abs(other.getRow() - row) != abs(other.getCol() - col))
            return false;
        final int dr = signum(other.getRow() - row);
        final int dc = signum(other.getCol() - col);
        int r = row + dr;
        int c = col + dc;
        while (r != other.getRow() || c != other.getCol()) {
            if (board.pieceAt(r, c) != null) return false;
            r += dr;
            c += dc;
        }
        return true;
    }
}
