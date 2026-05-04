package uebung04;

public interface Piece {
    Color getColor();

    Board getBoard();

    int getRow();

    int getCol();

    char charRep();

    boolean canCapture(Piece other);
}