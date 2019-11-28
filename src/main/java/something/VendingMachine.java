package something;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    public int amount;
    private List<Integer> changeBox = new ArrayList<>();
    private List<Integer> moneyBox = new ArrayList<>();
    List<DrinkStock> stocks = Arrays.asList(new DrinkStock("コーラ", 120, 5));
    private List<String> takeOutPort = new ArrayList<>();
    public VendingMachine(DrinkStock... stocks) {
        this.stocks.addAll(Arrays.asList(stocks));
    }

    public String getDrinkName(int i) {
        return stocks.get(i).name;
    }

    public void receive(int i) {
        if(i == 10 || i == 50 || i == 100 || i == 500 || i == 1000){
            amount+=i;
            moneyBox.add(i);
        }
        else{
            changeBox.add(i);
        }
    }

    public void repayment() {
        amount = 0;
        changeBox.addAll(moneyBox);
        moneyBox.clear();
    }

    public List<Integer> openChangeBox() {
        var l = new ArrayList<Integer>();
        l.addAll(changeBox);
        changeBox.clear();
        return l;
    }

    public DrinkStock getDrinkStock(int i) {
        return stocks.get(i);
    }

    public void pressed(int i) {
        takeOutPort.add(stocks.get(i).name);
        stocks.get(i).number--;
    }

    public List<String> openTakeOutPort() {
        var l = new ArrayList<String>();
        l.addAll(takeOutPort);
        takeOutPort.clear();
        return l;
    }
}
