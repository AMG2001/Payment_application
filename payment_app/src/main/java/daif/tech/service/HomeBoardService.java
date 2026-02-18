package daif.tech.service;

import daif.tech.model.User;
import daif.tech.repo.UserDB;

import java.math.BigDecimal;

public class HomeBoardService {

    private UserDB userDB = new UserDB();

    private User user;

    public void logout(){
        System.out.println("User Logged out successfully");
        user = null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkIfUserExists(String phoneNumber){
        return userDB.isUserExists(phoneNumber);
    }

    public void deposit(BigDecimal amount){
        userDB.deposit(user.getPhoneNumber(),amount);
    }

    public void withdraw(BigDecimal amount){
        userDB.withdraw(user.getPhoneNumber(),amount);
    }

    public double getBalance(){
        return userDB.getBalance(user.getPhoneNumber());
    }

    public void transfer(String receiverPhoneNumber,BigDecimal amount){
        userDB.transferToUser(user.getPhoneNumber(),receiverPhoneNumber,amount);
    }
}
