package uebung04.tournament;

import java.util.ArrayList;
import java.util.List;

public class SeededGame implements Game{
    private String player1;
    private String player2;
    private final ArrayList<String> players = new ArrayList<>();
    private GameData gamedata;

    public SeededGame(String player1, String player2){
        gamedata = new GameData();
        this.player1 = player1;
        this.player2 = player2;
        players.add(player1);
        players.add(player2);
    }

    @Override
    public int getID(){
        return gamedata.getID();
    }

    @Override
    public String getWinner(){
        return gamedata.getWinner();
    }

    @Override
    public String getPlayer1(){
        return player1;
    }

    @Override
    public String getPlayer2(){
        return player2;
    }

    @Override
    public ArrayList<String> getAllPlayers(){
        return players;
    }

    /*
    @Override
    public void setWinner(String name){
        if(player1 != null && player2 != null && (name.equals(player1) || name.equals(player2)) && gamedata.getWinner() == null){
            gamedata.setWinner(name);
        }
    }
    */


    @Override
    public void setWinner(String name){
        gamedata.setWinner(name, getPlayer1(), getPlayer2());
    }

    @Override
    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();
        games.add(this);
        return games;
    }

    @Override
    public String toString(){
        return "Game: " + getID() + " --> Player1: " + getPlayer1() + " vs Player2: " + getPlayer2();
    }
}
