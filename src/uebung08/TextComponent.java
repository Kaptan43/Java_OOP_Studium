package uebung08;

public interface TextComponent {
    public int countWords();

    public <T> T accept(Visitor<T> visitor);
}
