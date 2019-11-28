package something;

import java.util.Objects;

public class DrinkStock {
    public String name;
    public int price;
    public int number;
    public DrinkStock(String name, int price, int number) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinkStock that = (DrinkStock) o;
        return price == that.price &&
                number == that.number &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, number);
    }
}
