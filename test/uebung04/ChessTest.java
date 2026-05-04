package uebung04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ChessTest {
    // Das Zeilenende wird auf Windows-Systemen anders codiert als auf Nicht-Windows-Systemen.
    // Die folgende Zeile ermittelt die aktuelle Codierung.
    // EOL = "End of Line"
    private static final String LS = System.lineSeparator();
    private static final String HE = "    1   2   3   4   5   6   7   8" + LS;
    private static final String LI = "  +---+---+---+---+---+---+---+---+" + LS;
    private static final String EMP = " |   |   |   |   |   |   |   |   |" + LS;
    private static final String WK1 = " | n |   |   |   |   |   |   |   |" + LS;
    private static final String WQ3 = " |   |   | q |   |   |   |   |   |" + LS;
    private static final String CO1 = " |   |   | n |   | N | Q |   |   |" + LS;
    private static final String INIT_BOARD = board(EMP, EMP, EMP, EMP, EMP, EMP, EMP, EMP);
    private static final String WK61_BOARD = board(EMP, EMP, EMP, EMP, EMP, WK1, EMP, EMP);
    private static final String APP1_BOARD = board(EMP, EMP, EMP, EMP, WQ3, CO1, EMP, EMP);
    private static final String CHECK_TEXT1 = "white queen at (4, 2)" + LS +
                                              "   cannot capture black queen at (8, 6)" + LS +
                                              "   cannot capture white knight at (6, 4)" + LS +
                                              "black queen at (8, 6)" + LS +
                                              "   cannot capture white queen at (4, 2)" + LS +
                                              "   can capture white knight at (6, 4)" + LS +
                                              "white knight at (6, 4)" + LS +
                                              "   cannot capture white queen at (4, 2)" + LS +
                                              "   cannot capture black queen at (8, 6)" + LS;
    private static final String CHECK_TEXT2 = "white knight at (6, 3)" + LS +
                                              "   cannot capture black knight at (6, 5)" + LS +
                                              "   cannot capture black queen at (6, 6)" + LS +
                                              "   cannot capture white queen at (5, 3)" + LS +
                                              "black knight at (6, 5)" + LS +
                                              "   cannot capture white knight at (6, 3)" + LS +
                                              "   cannot capture black queen at (6, 6)" + LS +
                                              "   can capture white queen at (5, 3)" + LS +
                                              "black queen at (6, 6)" + LS +
                                              "   cannot capture white knight at (6, 3)" + LS +
                                              "   cannot capture black knight at (6, 5)" + LS +
                                              "   cannot capture white queen at (5, 3)" + LS +
                                              "white queen at (5, 3)" + LS +
                                              "   cannot capture white knight at (6, 3)" + LS +
                                              "   cannot capture black knight at (6, 5)" + LS +
                                              "   cannot capture black queen at (6, 6)" + LS;

    private static String board(String... s) {
        if (s.length != 8)
            throw new IllegalArgumentException("Expected 8, but got " + s.length + " arguments");
        StringBuilder sb = new StringBuilder();
        sb.append(HE).append(LI);
        for (int i = 1; i <= 8; i++)
            sb.append(i).append(s[i - 1]).append(LI);
        return sb.toString();
    }

    private Board board;

    private final ByteArrayOutputStream printed = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(printed, true);

    @Before
    public void setup() {
        board = new Board();
        printed.reset();
        System.setOut(printStream);
    }

    @After
    public void tearDown() {
        printStream.close();
    }

    @Test
    public void testEmpty() {
        board.printBoard();
        assertEquals(INIT_BOARD, printed.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPos1() {
        new Knight(Color.white, board, 0, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPos2() {
        new Queen(Color.white, board, 0, 4);
    }

    @Test
    public void testWhiteknight() {
        final Piece knight = new Knight(Color.white, board, 6, 1);
        checkPieces(1);
        assertEquals(knight, board.pieceAt(6, 1));
        board.printBoard();
        assertEquals(WK61_BOARD, printed.toString());
    }

    @Test
    public void test3Pieces() {
        final Piece queen1 = new Queen(Color.white, board, 4, 2);
        final Piece queen2 = new Queen(Color.black, board, 8, 6);
        final Piece knight = new Knight(Color.white, board, 6, 4);
        Assert.assertFalse(queen1.canCapture(queen2));
        Assert.assertFalse(queen1.canCapture(knight));
        Assert.assertFalse(queen2.canCapture(queen1));
        Assert.assertTrue(queen2.canCapture(knight));
        Assert.assertFalse(knight.canCapture(queen1));
        Assert.assertFalse(knight.canCapture(queen2));
        checkPieces(3);
        assertEquals(queen1, board.pieceAt(4, 2));
        assertEquals(queen2, board.pieceAt(8, 6));
        assertEquals(knight, board.pieceAt(6, 4));
        board.check();
        assertEquals(CHECK_TEXT1, printed.toString());
    }

    @Test
    public void test4Pieces() {
        final Piece knight1 = new Knight(Color.white, board, 6, 3);
        final Piece knight2 = new Knight(Color.black, board, 6, 5);
        final Piece queen1 = new Queen(Color.black, board, 6, 6);
        final Piece queen2 = new Queen(Color.white, board, 5, 3);
        checkPieces(4);
        assertEquals(knight1, board.pieceAt(6, 3));
        assertEquals(knight2, board.pieceAt(6, 5));
        assertEquals(queen1, board.pieceAt(6, 6));
        assertEquals(queen2, board.pieceAt(5, 3));
        board.printBoard();
        assertEquals(APP1_BOARD, printed.toString());
        Assert.assertFalse(knight1.canCapture(knight2));
        Assert.assertFalse(knight1.canCapture(queen1));
        Assert.assertFalse(knight1.canCapture(queen2));
        Assert.assertFalse(knight2.canCapture(knight1));
        Assert.assertFalse(knight2.canCapture(queen1));
        Assert.assertTrue(knight2.canCapture(queen2));
        Assert.assertFalse(queen1.canCapture(knight1));
        Assert.assertFalse(queen1.canCapture(knight2));
        Assert.assertFalse(queen1.canCapture(queen2));
        Assert.assertFalse(queen2.canCapture(knight1));
        Assert.assertFalse(queen2.canCapture(knight2));
        Assert.assertFalse(queen2.canCapture(queen1));
        printed.reset();
        board.check();
        assertEquals(CHECK_TEXT2, printed.toString());
    }

    private void checkPieces(int expectedNumPieces) {
        int numPieces = 0;
        for (int row = 1; row < 9; row++)
            for (int col = 1; col < 9; col++)
                if (board.pieceAt(row, col) != null)
                    numPieces++;
        assertEquals(expectedNumPieces, numPieces);
    }

    @Test
    public void testRunWithErrors() {
        final Piece rook = new Rook(Color.white, board, 1, 1);
        assertEquals(rook, board.pieceAt(1, 1));
    }
}