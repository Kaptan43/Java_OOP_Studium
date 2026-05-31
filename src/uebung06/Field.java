package uebung06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Field {
    private final int x;
    private final int y;
    private Value value;
    private final Sudoku sudoku;
    private List<Field> dependents;
    private final Set<Value> domain;

    public Field(int x, int y, Sudoku sudoku){
        this.x = x;
        this.y = y;
        value = null;
        this.sudoku = sudoku;
        dependents = null;
        domain = new HashSet<>(Arrays.asList(Value.values()));
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Value getValue(){
        return value;
    }

    public Sudoku getSudoku(){
        return sudoku;
    }

    public boolean isEmpty(){
        return value==null;
    }

    public void setValue(Value value){
        this.value = value;
        for(Field field : getDependents()){
            field.domain.remove(value);
        }
    }

    public List<Field> getDependents(){
        if(dependents == null){
            dependents = new ArrayList<>();

            //Zeile
            for(int i = 0; i < 9; i++){
                if(i != y) dependents.add(sudoku.getField(x, i));
            }

            //Spalte
            for(int i = 0; i < 9; i++){
                if(i != x) dependents.add(sudoku.getField(i, y));
            }

            //Block
            int blockX = (x / 3) * 3;
            int blockY = (y / 3) * 3;
            for(int i = blockX; i < blockX+3; i++){
                for(int j = blockY; j < blockY+3; j++){
                    if(i != x  || j != y) dependents.add(sudoku.getField(i,j));
                }
            }

        }
        return dependents;
    }

    public Set<Value> getDomain(){
        if(value != null) return new HashSet<>();
        else{
            return domain;
        }
    }

    @Override
    public String toString(){
        return (value == null ? "." : value.toString());

        /*
        if(value == null) return ".";
        else{
            return value.toString();
        }
         */

    }

}
