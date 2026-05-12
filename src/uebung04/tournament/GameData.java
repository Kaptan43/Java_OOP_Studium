package uebung04.tournament;

class GameData {
    private int id;
    private static int counter;
    private String winner;

    GameData(){
        id = counter++;
    }

    int getID(){
        return id;
    }

    String getWinner(){
        return winner;
    }

    public void setWinner(String name, String p1, String p2){
        if(getWinner() != null){
            throw new IllegalStateException("Gewinner des Spiels steht bereits fest!");
        }
        if(p1 == null || p2 == null){
            throw new IllegalStateException("Mindestens einer der Spieler steht noch nicht fest!");
        }
        if(!name.equals(p1) && !name.equals(p2)){
            throw new IllegalArgumentException("Gewinner stimmt nicht mit den Namen der Spieler des Spiels überein!");
        }
        winner = name;
    }
}
