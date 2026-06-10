/*
package uebung07;

import oop.ch04.secured.AuthorizationException;
import org.junit.Before;
import org.junit.Test;

import static oop.ch04.mensa.FreeMealCardColor.gray;
import static oop.ch04.mensa.PrepaidCardColor.blue;
import static oop.ch04.mensa.PrepaidCardColor.green;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MensaTest {
    private static final String CONF_ACCOUNT = "33-1298";
    private static final String OTHER_ACCOUNT = "33-1299";
    private AccountManagement accountMgt;
    private TopUpStation vm1;
    private TopUpStation vm2;
    private TopUpStation tumVM;
    private AccessGate unibwMensa;

    private AccountChargeCard conf;
    private MensaCard frankSmith;
    private PrepaidCard hansMueller;
    private PrepaidCard peterSchmidt;
    private PrepaidCard thomasMayer;

    @Before
    public void setup() {
        accountMgt = new AccountManagement(4711, "UniBw admin");

        vm1 = new TopUpStation("left", 4711);
        vm2 = new TopUpStation("right", 4711);
        tumVM = new TopUpStation("TUM Mensa", 3141);
        unibwMensa = new AccessGate("UniBw Mensa", 4711, accountMgt);

        conf = new AccountChargeCard("conference", CONF_ACCOUNT, 42);
        frankSmith = new FreeMealCard("Frank Smith", gray);
        hansMueller = new PrepaidCard("Hans Müller", green, 4711);
        peterSchmidt = new PrepaidCard("Peter Schmidt", green, 4711);
        thomasMayer = new PrepaidCard("Thomas Mayer", blue, 4711);
    }

    @Test
    public void testPayment() throws AuthorizationException, PaymentRejectedException {
        vm1.topUp(hansMueller, 10);
        vm1.topUp(peterSchmidt, 5);
        vm2.topUp(thomasMayer, 2);
        assertThrows(AuthorizationException.class, () -> tumVM.topUp(hansMueller, 10));

        assertEquals(15, vm1.getTotalTopUpAmount());
        assertEquals(2, vm2.getTotalTopUpAmount());
        assertEquals(0, tumVM.getTotalTopUpAmount());
        assertEquals(1000, hansMueller.getBalance());
        assertEquals(500, peterSchmidt.getBalance());
        assertEquals(200, thomasMayer.getBalance());

        unibwMensa.scan(hansMueller);
        assertEquals(733, hansMueller.getBalance());
        assertEquals(1, unibwMensa.getTotalScans());
        assertEquals(267, unibwMensa.getTotalChargedAmount());

        unibwMensa.scan(frankSmith);
        assertEquals(0, accountMgt.getAmount(CONF_ACCOUNT));
        assertThrows(PaymentRejectedException.class, () -> unibwMensa.scan(conf));
        assertThrows(PaymentRejectedException.class, () -> unibwMensa.scan(thomasMayer));

        unibwMensa.scan(hansMueller);
        unibwMensa.scan(hansMueller);
        assertEquals(199, hansMueller.getBalance());

        assertThrows(PaymentRejectedException.class, () -> unibwMensa.scan(hansMueller));

        accountMgt.deposit(CONF_ACCOUNT, 1000);
        accountMgt.deposit(OTHER_ACCOUNT, 2000);
        assertEquals(100000, accountMgt.getAmount(CONF_ACCOUNT));
        assertEquals(200000, accountMgt.getAmount(OTHER_ACCOUNT));

        unibwMensa.scan(conf);
        assertEquals(99505, accountMgt.getAmount(CONF_ACCOUNT));
        assertEquals(200000, accountMgt.getAmount(OTHER_ACCOUNT));
        assertEquals(5, unibwMensa.getTotalScans());
    }
}

 */