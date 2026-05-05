package uebung04.tournament;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TournamentTest {

    private static final String BORGHOFF = "Prof. Borghoff";
    private static final String HOMMEL = "Prof. Hommel";
    private static final String KOCH = "Prof. Koch";
    private static final String MINAS = "Prof. Minas";
    private static final String BUCHENRIEDER = "Prof. Buchenrieder";
    private static final String DREO = "Prof. Dreo";
    private static final String ROSE = "Prof. Rose";
    private static final String SIEGLE = "Prof. Siegle";
    private static final String TEEGE = "Prof. Teege";
    private static final Set<String> SET1 = Set.of(BORGHOFF, HOMMEL, KOCH, MINAS, BUCHENRIEDER, DREO, ROSE, SIEGLE, TEEGE);
    private static final Set<String> SET2 = Set.of(BORGHOFF, MINAS, SIEGLE, HOMMEL, DREO);
    private static final Set<String> SET3 = Set.of(BORGHOFF, MINAS, SIEGLE);
    private static final Set<String> SET4 = Set.of(MINAS, SIEGLE);
    private static final Set<String> SET5 = Set.of(MINAS);

    private Tournament tournament;
    private Game r1s1;
    private Game r1s2;
    private Game r1s3;
    private Game r1s4;
    private Game r2s1;
    private Game r2s2;
    private Game r3s1;
    private Game r4s1;

    @Before
    public void setup() {
        r1s1 = new SeededGame(HOMMEL, KOCH);
        r1s2 = new SeededGame(MINAS, BUCHENRIEDER);
        r1s3 = new SeededGame(DREO, ROSE);
        r1s4 = new SeededGame(SIEGLE, TEEGE);
        r2s1 = new ByeGame(BORGHOFF, r1s1);
        r2s2 = new OrdinaryGame(r1s2, r1s3);
        r3s1 = new OrdinaryGame(r2s1, r2s2);
        r4s1 = new OrdinaryGame(r3s1, r1s4);
        tournament = new Tournament("UniBw Sportschießen", r4s1);
    }

    @Test
    public void testBeforeFirstRound() {
        assertEquals(SET1, asSet(tournament.getAllPlayers()));
        assertEquals(SET1, asSet(tournament.getRemainingPlayers()));
    }

    @Test
    public void testFirstRound() {
        r1s1.setWinner(HOMMEL);
        r1s2.setWinner(MINAS);
        r1s3.setWinner(DREO);
        r1s4.setWinner(SIEGLE);
        assertEquals(SET1, asSet(tournament.getAllPlayers()));
        assertEquals(SET2, asSet(tournament.getRemainingPlayers()));
    }

    @Test
    public void testSecondRound() {
        r1s1.setWinner(HOMMEL);
        r1s2.setWinner(MINAS);
        r1s3.setWinner(DREO);
        r1s4.setWinner(SIEGLE);
        r2s1.setWinner(BORGHOFF);
        r2s2.setWinner(MINAS);
        assertEquals(SET1, asSet(tournament.getAllPlayers()));
        assertEquals(SET3, asSet(tournament.getRemainingPlayers()));
    }

    @Test
    public void testThirdRound() {
        r1s1.setWinner(HOMMEL);
        r1s2.setWinner(MINAS);
        r1s3.setWinner(DREO);
        r1s4.setWinner(SIEGLE);
        r2s1.setWinner(BORGHOFF);
        r2s2.setWinner(MINAS);
        r3s1.setWinner(MINAS);
        assertEquals(SET1, asSet(tournament.getAllPlayers()));
        assertEquals(SET4, asSet(tournament.getRemainingPlayers()));
    }

    @Test
    public void testCompleteTournament() {
        r1s1.setWinner(HOMMEL);
        r1s2.setWinner(MINAS);
        r1s3.setWinner(DREO);
        r1s4.setWinner(SIEGLE);
        r2s1.setWinner(BORGHOFF);
        r2s2.setWinner(MINAS);
        r3s1.setWinner(MINAS);
        r4s1.setWinner(MINAS);
        assertEquals(SET1, asSet(tournament.getAllPlayers()));
        assertEquals(SET5, asSet(tournament.getRemainingPlayers()));
    }

    @Test
    public void testException() {
        r1s1.setWinner(HOMMEL);
        r1s2.setWinner(MINAS);
        r1s3.setWinner(DREO);
        r1s4.setWinner(SIEGLE);
        r2s1.setWinner(BORGHOFF);
        r2s2.setWinner(MINAS);
        r3s1.setWinner(MINAS);
        assertThrows(IllegalArgumentException.class, () -> r4s1.setWinner(BUCHENRIEDER));
    }

    @Test(expected = IllegalStateException.class)
    public void testException2() {
        r4s1.setWinner(MINAS);
    }

    @Test
    public void testException3() {
        r1s1.setWinner(HOMMEL);
        assertThrows(IllegalStateException.class, () -> r1s1.setWinner(HOMMEL));
    }

    private static <T> Set<T> asSet(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}
