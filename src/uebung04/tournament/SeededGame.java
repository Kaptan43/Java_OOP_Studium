package uebung04.tournament;

import java.util.ArrayList;

public class SeededGame implements Game {
    private String player1;
    private String player2;
    private ArrayList<String> players = new ArrayList<>();
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

    @Override
    public void setWinner(String name){
        if(player1 != null && player2 != null && (name.equals(player1) || name.equals(player2)) && gamedata.getWinner() == null){
            gamedata.setWinner(name);
        }
    }
}
