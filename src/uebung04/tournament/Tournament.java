package uebung04.tournament;

import java.util.ArrayList;
import java.util.List;

public class Tournament{
    private String name;
    private Game finalGame;

    public Tournament(String name, Game finalGame){
        this.name = name;
        this.finalGame = finalGame;
    }

    public List<String> getAllPlayers(){
        List<String> players = new ArrayList<>();
        players.addAll(finalGame.getAllPlayers());
        return players;
    }
/*
    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();
        games.addAll(finalGame.getAllGames());
        return games;
    }
*/
    public List<Game> getAllGames(){
        return new ArrayList<>(List.of(finalGame.getAllGames().toArray(new Game[0])));
    }

    /* --> Erster Gedanke
    public List<String> getRemainingPlayers(){
        List<String> remaining = new ArrayList<>();
        if(finalGame.getWinner() != null){
            remaining.add(finalGame.getWinner());
        }
        for(Game game : getAllGames()){
            if(game.getWinner() == null){                       //Auch möglich: if(!game.getAllPlayers().isEmpty() && game.getWinner() == null)
                if(game.getPlayer1() != null) remaining.add(game.getPlayer1());
                if(game.getPlayer2() != null) remaining.add(game.getPlayer2());
            }
            if(game.getWinner() != null){
                if(game.getWinner().equals(game.getPlayer1())) remaining.remove(game.getPlayer2());
                if(game.getWinner().equals(game.getPlayer2())) remaining.remove(game.getPlayer1());
            }
        }
        return remaining;
    }
    */

    // --> Empfohlen mit Liste der Verlierer
    public List<String> getRemainingPlayers(){
        List<String> remaining = new ArrayList<>(getAllPlayers()); //Alle Spieler
        List<String> losers = new ArrayList<>();

        for(Game game : getAllGames()){
            if(game.getWinner() != null){
                if(game.getPlayer1() != null && !game.getPlayer1().equals(game.getWinner())){
                    losers.add(game.getPlayer1());
                }
                if(game.getPlayer2() != null && !game.getPlayer2().equals(game.getWinner())){
                    losers.add(game.getPlayer2());
                }
            }
        }
        remaining.removeAll(losers);
        return remaining;
    }

}

