package uebung08;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private List<TextComponent> contents = new ArrayList<>();

    public Book(String author, String title, List<TextComponent> contents){
        this.author = author;
        this.title = title;
        this.contents = contents;
    }

    public int countWords(){
        int counter = 0;

        for(TextComponent tc : contents){
            counter += tc.countWords();
        }
        return counter;
    }

    public int countWordsByVisitor(){
        int counter = 0;

        Visitor<Integer> visitor = new CountWordsVisitor();

        for(TextComponent tc : contents){
            counter += tc.accept(visitor);
        }
        return counter;
    }

}

