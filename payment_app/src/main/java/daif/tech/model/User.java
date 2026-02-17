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
}
