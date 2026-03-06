package daif.tech.model;

import daif.tech.exception.AvailableBalanceNotEnoughException;

import java.math.BigDecimal;

public class User {
    private UserKey userKey;
    private String password;
    private BigDecimal balance;
    private int age;
    private boolean isAdmin;

    public User(String userName, String password, String phoneNumber,int age, BigDecimal balance) {
        this.userKey = new UserKey(phoneNumber,userName);
        this.password = password;
        this.age = age;
        this.balance = balance;
        isAdmin = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public UserKey getUserKey() {
        return userKey;
    }

    public String getUserName() {
        return userKey.getUserName();
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return userKey.getPhoneNumber();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount){
        if(amount.doubleValue()<0){
            System.out.println("You can't add amount with negative value");
        }else balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws AvailableBalanceNotEnoughException {
        if(amount.doubleValue()<=0){
            throw new IllegalArgumentException("Entered amount can't be negative or zero");
        }
        if(balance.subtract(amount).doubleValue()<0){
            throw new AvailableBalanceNotEnoughException();
        }else{
            balance = balance.subtract(amount);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userKey=" + userKey +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                '}';
    }
}
