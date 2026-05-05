package uebung04.tournament;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
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

    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<>();
        games.addAll(finalGame.getAllGames());
        return games;
    }

    public List<String> getRemainingPlayers(){
        List<String> remaining = new ArrayList<>();
        for(Game game : this.getAllGames()){
            if(game.getWinner() == null){                       //Auch möglich: if(!game.getAllPlayers().isEmpty() && game.getWinner() == null)
                if(game.getPlayer1() != null) remaining.add(game.getPlayer1());
                if(game.getPlayer2() != null) remaining.add(game.getPlayer2());
            }
        }
        return remaining;
    }

}

