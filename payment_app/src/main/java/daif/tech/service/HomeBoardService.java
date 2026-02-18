package daif.tech.service;

import daif.tech.model.User;

import java.math.BigDecimal;

public class HomeBoardService {

    private User user;

    public void deposit(BigDecimal amount){
        user.deposit(amount);
    }

    public void withdraw(BigDecimal amount){
        user.withdraw(amount);
    }

    public void logout(){
        System.out.println("User Logged out successfully");
        user = null;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
