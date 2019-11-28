package something;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VendingMachineSpec {

    @Test
    public void お金を投入できる_有効なお金(){
        var machine = new VendingMachine();
        machine.receive(10);
        Assertions.assertEquals(10, machine.amount);
        machine.receive(50);
        Assertions.assertEquals(60, machine.amount);
        machine.receive(100);
        Assertions.assertEquals(160, machine.amount);
        machine.receive(500);
        Assertions.assertEquals(660, machine.amount);
        machine.receive(1000);
        Assertions.assertEquals(1660, machine.amount);
    }

    @Test
    public void お金を投入できる_無効なお金(){
        var machine = new VendingMachine();
        machine.receive(-1);
        Assertions.assertEquals(0, machine.amount);
        machine.receive(1);
        Assertions.assertEquals(0, machine.amount);
        machine.receive(5);
        Assertions.assertEquals(0, machine.amount);
        machine.receive(5000);
        Assertions.assertEquals(0, machine.amount);
        machine.receive(10000);
        Assertions.assertEquals(0, machine.amount);
        machine.receive(10001);
        Assertions.assertEquals(0, machine.amount);
    }

    @Test
    public void 返却ボタンで釣り銭がでてくる(){
        var machine = new VendingMachine();
        machine.receive(10);
        machine.repayment();
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(10), machine.openChangeBox());

        machine.receive(10);
        machine.receive(50);
        machine.repayment();
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(10, 50), machine.openChangeBox());
    }

    @Test
    public void 無効なお金をいれると釣り銭BOXにはいっている(){
        var machine = new VendingMachine();
        machine.receive(-1);
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(-1), machine.openChangeBox());
        machine.receive(1);
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(1), machine.openChangeBox());
        machine.receive(5);
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(5), machine.openChangeBox());
        machine.receive(5000);
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(5000), machine.openChangeBox());
        machine.receive(10000);
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(10000), machine.openChangeBox());
        machine.receive(10001);
        Assertions.assertEquals(0, machine.amount);
        Assertions.assertEquals(Arrays.asList(10001), machine.openChangeBox());
    }


    @Test
    public void コーラをうっている(){
        var machine = new VendingMachine();
        Assertions.assertEquals("コーラ", machine.getDrinkName(0));
        Assertions.assertEquals(new DrinkStock("コーラ", 120, 5), machine.getDrinkStock(0));
    }

    @Test
    public void コーラをかえる(){
        var machine = new VendingMachine();
        machine.receive(100);
        machine.receive(10);
        machine.receive(10);
        machine.pressed(0);
        Assertions.assertEquals(Arrays.asList("コーラ"), machine.openTakeOutPort());

    }

}
