package uebung08;

import java.util.List;

public class ToTextVisitor implements Visitor<String>{

    private final String prefix;
    private int sectionCounter;
    private int imageCounter;

    public ToTextVisitor(String prefix){
        this.prefix = prefix;
    }

    @Override
    public String visit(Paragraph paragraph) {
        return paragraph.getText() + "\n";
    }

    @Override
    public  String visit(Image image) {
        imageCounter++;
        String nummer = prefix + imageCounter;

        StringBuilder sb = new StringBuilder();
        sb.append("<image " + image.getUrl() + ">" + "\n");
        sb.append("Fig. " + nummer + ": " + image.getCaption() + "\n");

        return sb.toString();
    }

    @Override
    public String visit(Section section) {
        sectionCounter++;
        String nummer = prefix + sectionCounter;

        StringBuilder sb = new StringBuilder();

        String header = nummer + " " + section.getHeader();
        sb.append(header + "\n");

        Visitor<String> childVisitor = new ToTextVisitor(nummer + ".");

        for(TextComponent tc : section.getContents()){
            sb.append(tc.accept(childVisitor));
        }
        return sb.toString();
    }

}
