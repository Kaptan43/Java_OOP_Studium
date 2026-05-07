package uebung04.tournament;

import java.util.ArrayList;
import java.util.List;

public class ByeGame implements Game {

    private String player1;
    private Game previousGame;
    private GameData gamedata;

    public ByeGame(String player1, Game previousGame){
        gamedata = new GameData();
        this.player1 = player1;
        this.previousGame = previousGame;
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
        return previousGame.getWinner();
    }

    @Override
    public List<String> getAllPlayers(){
        List<String> players = new ArrayList<>();
        players.add(player1);
        players.addAll(previousGame.getAllPlayers());
        return players;
    }

    /*
    @Override
    public void setWinner(String name){
        if(player1 != null && this.getPlayer2() != null && (name.equals(player1) || name.equals(this.getPlayer2())) && gamedata.getWinner() == null){
            gamedata.setWinner(name);
        }
    }
    */

    // --> Mit Exception
    @Override
    public void setWinner(String name){
        if(gamedata.getWinner() != null){
            throw new IllegalStateException("Gewinner des Spiels steht bereits fest!");
        }
        if(player1 == null || getPlayer2() == null){
            throw new IllegalStateException("Mindestens einer der Spieler steht noch nicht fest!");
        }
        if(!name.equals(player1) && !name.equals(getPlayer2())){
            throw new IllegalArgumentException("Gewinner stimmt nicht mit den Namen der Spieler des Spiels überein!");
        }
        gamedata.setWinner(name);
    }

    @Override
    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();
        games.addAll(previousGame.getAllGames());
        games.add(this);
        return games;
    }

    @Override
    public String toString(){
        return "Game: " + getID() + " --> Player1: " + getPlayer1() + " vs Player2: " + getPlayer2();
    }
}

