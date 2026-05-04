package uebung04.chess;

import static java.lang.Math.abs;

public class Knight implements Piece {
    private final Color color;
    private final Board board;
    private final int row;
    private final int col;

    public Knight(Color color, Board board, int row, int col) {
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
        return color == Color.white ? 'n' : 'N';
    }

    @Override
    public String toString() {
        return color + " knight at (" + row + ", " + col + ")";
    }

    @Override
    public boolean canCapture(Piece other) {
        if (board != other.getBoard() || color == other.getColor())
            return false;
        final int dr = abs(row - other.getRow());
        final int dc = abs(col - other.getCol());
        return dr == 2 && dc == 1 || dr == 1 && dc == 2;
    }
}
