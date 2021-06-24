package entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AccountTests {

    @Test
    public void depositShoudIncreaseBalanceWhenPositiveAmount(){

        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createAccount();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public  void  depositShouldDoNothinNegativeAmount(){

        double expectedValue = 100.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;


        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance(){
        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);
        double result = acc.fullWinthdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSuffucuentBalance() throws IllegalAccessException {

        Account acc = AccountFactory.createAccount(800.0);

        acc.withdraw(500.0);

        Assertions.assertEquals(300, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptioneWhenInsuffucuentBalance() throws IllegalAccessException {
        Assertions.assertThrows(IllegalAccessException.class, ()->{
            Account acc = AccountFactory.createAccount(800.0);
            acc.withdraw(801.0);
        });

    }


}
