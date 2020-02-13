
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class TestDeposit {
    public static void main(String[] args){
        Deposit dep = new Deposit();
        Service srv = new Service();
        ArrayList<Deposit> deposits = srv.init();
        srv.getPrincipal(deposits);
        srv.display(deposits);
        srv.remove(deposits);
        srv.display(deposits);
        Collections.sort(deposits);

        Collections.sort(deposits, dep.comparator);
        srv.display(deposits);

        Collections.sort(deposits, dep.comparator1);
        srv.display(deposits);

        NewComparator comp = new NewComparator();
        Collections.sort(deposits,comp);
        srv.display(deposits);

        System.out.println(deposits.get(0).equals(deposits.get(5)));
        System.out.println(deposits.get(0).hashCode());
        System.out.println(deposits.get(5).hashCode());

        HashSet<Deposit> hs = new HashSet<Deposit>();
        hs.add(deposits.get(0));
        hs.add(deposits.get(5));

        System.out.println(hs.size());

        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> llist = new LinkedList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
            llist.add(i);
        }

        Instant start = Instant.now();
        for (int j = 5; j < 115; j++){
            list.add(j, j+1);
        }
        Instant end = Instant.now();
        Duration runTime = Duration.between(start, end);
        int sec= (int)runTime.getSeconds();

        System.out.println("Program runs " + sec);

        for (int entry: list) {
            System.out.println(entry);
        }



    }
}
