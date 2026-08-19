package uebung08;

import java.util.ArrayList;
import java.util.List;

public class TableOfContentsVisitor implements Visitor<List<String>> {
    private final String prefix;        //z.B. "" (oberste Ebene) oder "4." (erste Ebene) oder "4.1." (zweite Ebene)
    private int counter = 0;            //zählt die direkten Kinder-Sections dieser Ebene

    public TableOfContentsVisitor(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public List<String> visit(Paragraph paragraph) {
        return new ArrayList<>();   //leere Liste, kein Beitrag
    }

    @Override
    public List<String> visit(Image image) {
        return new ArrayList<>();   //leere Liste, kein Beitrag
    }

    @Override
    public List<String> visit(Section section) {
        //Schritt A: eigene Nummer bestimmen (Zähler hochzählen)
        counter++;
        String nummer = prefix + counter;   //z.B. "4" oder "4.1"

        //Schritt B: eigene Überschrift-Zeile eintragen
        List<String> result = new ArrayList<>();
        result.add(nummer + " " + section.getHeader());

        //Schritt C: neuen Visitor für die KINDER erzeugen - mit neuem Präfix, eigenem Zähler bei 0
        Visitor<List<String>> childVisitor = new TableOfContentsVisitor(nummer + ".");

        //Schritt D: Kinder durchgehen, deren Ergebnis-Listen anhängen
        for(TextComponent tc : section.getContents()){
            result.addAll(tc.accept(childVisitor));
        }

        return result;
    }

}
