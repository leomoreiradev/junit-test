package entities;



//Padrão de projeto Factory para instanciar objetos
public class AccountFactory {
    public static Account createAccount() {
        return new Account(1L, 0.0);
    }

    public static Account createAccount(double initialBalance) {
        return new Account(1L, initialBalance);
    }
}
