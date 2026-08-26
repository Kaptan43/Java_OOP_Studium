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

    public List<String> tableOfContents(){
        Visitor<List<String>> visitor = new TableOfContentsVisitor("");     //Startpräfix: leer
        List<String> result = new ArrayList<>();

        for(TextComponent tc : contents){
            result.addAll(tc.accept(visitor));
        }
        return result;
    }

    public String toText(){
        Visitor<String> visitor = new ToTextVisitor("");
        StringBuilder sb = new StringBuilder();
        sb.append(author);     //sb.append(author + "\n" + title + "\n");
        sb.append("\n");
        sb.append(title);
        sb.append("\n");

        for(TextComponent tc : contents){
            sb.append(tc.accept(visitor));
        }
        return sb.toString();
    }

}

