package uebung04.tournament;

public class Demo {

    public static void main(String[] args){
        Game r1s1 = new SeededGame("Lancelot", "Parzival");
        Game r1s2 = new SeededGame("Tristan", "Gawain");
        Game r1s3 = new SeededGame("Galahad", "Mordred");
        Game r2s1 = new ByeGame("Artus", r1s1);
        Game r2s2 = new OrdinaryGame(r1s2, r1s3);
        Game r3s1 = new OrdinaryGame(r2s1, r2s2);

        Tournament tafelrunde = new Tournament("Tafelrunde", r3s1);

        System.out.println("Remaining Players at the beginning: " + tafelrunde.getRemainingPlayers());

        r1s1.setWinner("Lancelot");
        System.out.println("Winner r1s1: " + r1s1.getWinner());
        System.out.println("Remaining Players: " + tafelrunde.getRemainingPlayers());

        r1s2.setWinner("Gawain");
        System.out.println("Winner r1s2: " + r1s2.getWinner());
        System.out.println("Remaining Players: " + tafelrunde.getRemainingPlayers());

        r1s3.setWinner("Galahad");
        System.out.println("Winner r1s3: " + r1s3.getWinner());
        System.out.println("Remaining Players: " + tafelrunde.getRemainingPlayers());

        r2s1.setWinner("Lancelot");
        System.out.println("Winner r2s1: " + r2s1.getWinner());
        System.out.println("Remaining Players: " + tafelrunde.getRemainingPlayers());

        r2s2.setWinner("Galahad");
        System.out.println("Winner r2s2: " + r2s2.getWinner());
        System.out.println("Remaining Players: " + tafelrunde.getRemainingPlayers());

        r3s1.setWinner("Lancelot");
        System.out.println("Winner r3s1: " + r3s1.getWinner());
        System.out.println("Remaining Players: " + tafelrunde.getRemainingPlayers());

        System.out.println("All games: " + tafelrunde.getAllGames());
        System.out.println("All players: " + tafelrunde.getAllPlayers());

    }
}
