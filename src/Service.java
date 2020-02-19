
import java.io.*;
import java.util.*;

public class Service implements Comparable<Deposit> {

    public void init() throws IOException {

        ArrayList<Deposit> deposits = new ArrayList<>();
        Deposit dep1 = new Deposit("Simple", new Date(2013-9-8), 61, 2500.00, 18.0);
        Deposit dep2 = new Deposit("MonthCapit", new Date(2012-12-1), 181, 10000.00, 21.0);
        Deposit dep3 = new Deposit("Simple", new Date(2013-12-11), 30, 5500.00, 15.3);
        Deposit dep4 = new Deposit("Barrier", new Date(2011-12-18), 370, 43000.00, 19.56);
        Deposit dep5 = new Deposit("MonthCapit", new Date(2013-12-7), 91, 12000.00, 16.0);
        Deposit dep6 = new Deposit("Simple", new Date(2013-9-8), 61, 2500.00, 18.0);

        deposits.add(dep1);
        deposits.add(dep2);
        deposits.add(dep3);
        deposits.add(dep4);
        deposits.add(dep5);
        deposits.add(dep6);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/Deposits.txt"));

        out.writeObject(deposits);

    }

    public double getPrincipal(ArrayList<Deposit> deposits){
        double totalSum1 = 0;
        double totalSum2 = 0;
        double totalSum3 = 0;

        for(int i = 0; i < deposits.size(); i++){
            totalSum1 += deposits.get(i).getSum();
        }

        Iterator<Deposit> iter= deposits.iterator();

        while(iter.hasNext()){
            totalSum2 += iter.next().getSum();
        }

        for(Deposit inst: deposits){
            totalSum3 += inst.getSum();
        }

        System.out.println(totalSum1);
        System.out.println(totalSum2);
        System.out.println(totalSum3);

        return totalSum1;

    }

    public void remove(ArrayList<Deposit> deposits){
        Iterator<Deposit> iter= deposits.iterator();

        while(iter.hasNext()){
            if(iter.next().getSum() < 10000){
                iter.remove();
            }
        }

    }



    public void display(ArrayList<Deposit> deposits){
        Iterator<Deposit> iter= deposits.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }


    Comparator<Deposit> comparator = new Comparator<Deposit>() {
        @Override
        public int compare(Deposit o1, Deposit o2) {
            return (int)(o1.getSum() - o2.getSum());
        }
    };

    Comparator<Deposit> comparator1 = (Deposit o1, Deposit o2) -> (int)(o1.getSum() - o2.getSum());

    @Override
    public int compareTo(Deposit o) {
        return 0;
    }
}
