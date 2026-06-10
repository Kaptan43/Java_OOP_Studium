package uebung08;

public interface Visitor<T> {
    T visit(Paragraph paragraph);
    T visit(Image image);
    T visit(Section section);
}
