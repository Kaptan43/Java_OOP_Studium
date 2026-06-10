package uebung08;

import static java.lang.Character.isLetter;
import static java.lang.Character.isWhitespace;

public class Paragraph implements TextComponent{
    private String text;

    public Paragraph(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    @Override
    public int countWords(){
        int sum = 0;
        char[] chars = text.toCharArray();
        for(int i=0; i<text.length(); i++){
            if(i==0 && isLetter(chars[i])){
                sum ++;
            }
            else {
                if(!isLetter(chars[i-1]) && isLetter(chars[i])) sum ++;
            }
        }
        return sum;
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visit(this);
    }

}
