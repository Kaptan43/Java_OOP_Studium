package uebung04.tournament;

import java.util.ArrayList;
import java.util.List;

public class OrdinaryGame implements Game {

    private Game previousGame1;
    private Game previousGame2;
    private GameData gamedata;

    public OrdinaryGame(Game previousGame1, Game previousGame2){
        gamedata = new GameData();
        this.previousGame1 = previousGame1;
        this.previousGame2 = previousGame2;
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
        return previousGame1.getWinner();
    }

    @Override
    public String getPlayer2(){
        return previousGame2.getWinner();
    }

    @Override
    public List<String> getAllPlayers(){
        List<String> players = new ArrayList<>();
        players.addAll(previousGame1.getAllPlayers());
        players.addAll(previousGame2.getAllPlayers());
        return players;
    }

    @Override
    public void setWinner(String name){
        if(this.getPlayer1() != null && this.getPlayer2() != null && (name.equals(this.getPlayer1()) || name.equals(this.getPlayer2())) && gamedata.getWinner() == null){
            gamedata.setWinner(name);
        }
    }

    @Override
    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();
        games.addAll(previousGame1.getAllGames());
        games.addAll(previousGame2.getAllGames());
        games.add(this);
        return games;
    }

    @Override
    public String toString(){
        return "Game: " + getID() + " --> Player1: " + getPlayer1() + " vs Player2: " + getPlayer2();
    }
}

