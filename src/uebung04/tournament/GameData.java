package uebung04.tournament;

class GameData {
    private int id;
    private static int counter;
    private String winner;

    GameData(){
        id = counter;
        counter ++;
        winner = null;
    }

    int getID(){
        return id;
    }

    String getWinner(){
        return winner;
    }

    void setWinner(String winner){
        this.winner = winner;
    }
}
