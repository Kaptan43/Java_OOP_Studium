package uebung04.tournament;

import java.util.ArrayList;

public interface Game {
    public int getID();
    public String getWinner();
    public void setWinner(String name);
    public String getPlayer1();
    public String getPlayer2();
    public ArrayList<String> getAllPlayers();
}

