package uebung04;

import static java.lang.Integer.signum;

public class Rook implements Piece {

    private final Color color;
    private final Board board;
    private final int row;
    private final int col;

    public Rook(Color color, Board board, int row, int col){
        if(row < 1 || row > 8 || col < 1 || col > 8){
            throw new IllegalArgumentException("Invalid pos " + row + "/" + col);
        }
        this.color = color;
        this.board = board;
        this.row = row;
        this.col = col;
        board.add(this);
    }

    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public Board getBoard(){
        return board;
    }

    @Override
    public int getRow(){
        return row;
    }

    @Override
    public int getCol(){
        return col;
    }

    @Override
    public char charRep(){
        return color == Color.white ? 'r' : 'R';
    }

    @Override
    public String toString(){
        return color + " rook at (" + row + ", " + col + ")";
    }

    @Override
    public boolean canCapture(Piece other){
        if(board != other.getBoard() || color == other.getColor()) return false;

        if(other.getRow() != row && other.getCol() != col) return false;

        final int dr = signum(other.getRow() - row);
        final int dc = signum(other.getCol() - col);
        int r = row + dr;
        int c = col + dc;

        while(r != other.getRow() || c != other.getCol()){
            if(board.pieceAt(r, c) != null) return false;
            r = r + dr;
            c += dc;
        }
        return true;
    }


}
