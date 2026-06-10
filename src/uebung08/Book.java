package uebung08;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private List<TextComponent> contents = new ArrayList<>();

    public Book(String title, String author, List<TextComponent> contents){
        this.title = title;
        this.author = author;
        this.contents = contents;
    }

    public int countWords(){
        int sum = 0;
        for(TextComponent tc : contents){
            sum += tc.countWords();
        }
        return sum;
    }

}
