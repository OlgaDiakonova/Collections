
import java.util.*;

public class Deposit implements Comparable<Deposit> {
    private String depoType;
    private Date startDate;
    private int dayLong;
    private double sum;
    private double interestRate;


    public Deposit(String depoType, Date startDate, int dayLong, double sum, double interestRate) {
        this.depoType = depoType;
        this.startDate = startDate;
        this.dayLong = dayLong;
        this.sum = sum;
        this.interestRate = interestRate;
    }

    public Deposit() {
    }

    public String getDepoType() {
        return depoType;
    }

    public void setDepoType(String depoType) {
        this.depoType = depoType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDayLong() {
        return dayLong;
    }

    public void setDayLong(int dayLong) {
        this.dayLong = dayLong;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString(){

        return this.getDepoType() + " " + this.getSum() + " " + this.getInterestRate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Deposit deposit = (Deposit) o;
        return dayLong == deposit.dayLong &&
                Double.compare(deposit.sum, sum) == 0 &&
                Double.compare(deposit.interestRate, interestRate) == 0 &&
                depoType.equals(deposit.depoType) &&
                startDate.equals(deposit.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depoType, startDate, dayLong, sum, interestRate);
    }

    @Override
    public int compareTo(Deposit o) {
        if(this.getInterestRate() > o.getInterestRate()){
            return 1;
        }else if(this.getInterestRate() < o.getInterestRate()){
            return -1;
        }else{
            return 0;
        }
    }

    Comparator<Deposit> comparator = new Comparator<Deposit>() {
        @Override
        public int compare(Deposit o1, Deposit o2) {
            return (int)(o1.getSum() - o2.getSum());
        }
    };

    Comparator<Deposit> comparator1 = (Deposit o1, Deposit o2) -> (int)(o1.getSum() - o2.getSum());
}


