package daif.tech.model;

import java.math.BigDecimal;

public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private BigDecimal balance;

    public User(String userName, String password, String phoneNumber, BigDecimal balance) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount){
        if(amount.doubleValue()<0){
            System.out.println("You can't add amount with negative value");
        }else balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        if(balance.subtract(amount).doubleValue()<0){
            System.out.println("The available balance is not enough to proceed");
        }else{
            balance = balance.subtract(amount);
        }
    }
}
