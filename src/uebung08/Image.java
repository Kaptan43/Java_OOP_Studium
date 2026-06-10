package uebung08;

public class Image implements TextComponent{
    private String url;
    private String caption;

    public Image(String url, String caption){
        this.url = url;
        this.caption = caption;
    }

    @Override
    public int countWords(){
        return 0;
    }

    @Override
    public <T> T accept(Visitor<T> visitor){
        return visitor.visit(this);
    }

}
