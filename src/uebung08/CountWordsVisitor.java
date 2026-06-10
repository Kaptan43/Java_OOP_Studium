package uebung08;

import static java.lang.Character.isLetter;

public class CountWordsVisitor implements Visitor<Integer>{

    @Override
    public Integer visit(Paragraph paragraph){
        int sum = 0;
        char[] chars = paragraph.getText().toCharArray();
        for(int i=0; i<paragraph.getText().length(); i++){
            if(i==0 && isLetter(chars[i])){
                sum ++;
            }
            else if(!isLetter(chars[i-1]) && isLetter(chars[i])) sum ++;
        }
        return sum;
    }

    @Override
    public Integer visit(Image image){
        return 0;
    }

    @Override
    public Integer visit(Section section){

    }
}
