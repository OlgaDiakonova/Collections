
import java.util.Comparator;

public class NewComparator implements Comparator<Deposit> {
    @Override
    public int compare(Deposit o1, Deposit o2) {
        return (int)(o1.getSum() - o2.getSum());
    }
}
