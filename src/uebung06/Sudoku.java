package uebung06;

public class Sudoku {
    private final Field[][] board;

    public Sudoku(){
        board = new Field[9][9];
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                board[x][y] = new Field(x, y, this);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < 9; y++){
            if(y == 3 || y == 6){
                sb.append("---------+---------+---------");
                sb.append("\n");
            }
            for(int x = 0; x < 9; x++){
                if(x==3 || x == 6) sb.append("| ");
                sb.append(" ");
                sb.append(board[x][y]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Field getField(int x, int y){
        return board[x][y];
    }

    public void initialize(int... values){
        int i = 0;

        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                if(values[i] != 0){
                    board[x][y].setValue(Value.of(values[i]));
                }
                i++;
            }
        }
    }



}
