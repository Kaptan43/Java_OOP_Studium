package uebung08;

import java.util.ArrayList;
import java.util.List;

public class Section implements TextComponent{
    private String header;
    private List<TextComponent> contents = new ArrayList<>();

    public Section(String header, List<TextComponent> contents){
        this.header = header;
        this.contents = contents;
    }

    @Override
    public  int countWords(){
        int sum = 0;
        for(TextComponent tc : contents){
            sum += tc.countWords();
        }

        return sum;
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visit(this);
    }

}
