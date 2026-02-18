package daif.tech.service;

import daif.tech.model.Transaction;
import daif.tech.model.User;
import daif.tech.repo.TransactionDB;
import daif.tech.repo.UserDB;

import java.math.BigDecimal;

public class HomeBoardService {

    private UserDB userDB = new UserDB();
    TransactionDB transactionDB = new TransactionDB();

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
        transactionDB.logNewTransaction(new Transaction(
                String.format("User with phone number : \"%s\" is depositing %.2f",user.getPhoneNumber(),amount.doubleValue())
        ));
    }

    public void withdraw(BigDecimal amount){
        userDB.withdraw(user.getPhoneNumber(),amount);
        transactionDB.logNewTransaction(new Transaction(
                String.format("User with phone number : \"%s\" is withdrawing %.2f",user.getPhoneNumber(),amount.doubleValue())
        ));
    }

    public double getBalance(){
        return userDB.getBalance(user.getPhoneNumber());
    }

    public void transfer(String receiverPhoneNumber,BigDecimal amount){
        userDB.transferToUser(user.getPhoneNumber(),receiverPhoneNumber,amount);
        transactionDB.logNewTransaction(new Transaction(
                String.format("User with phone number : \"%s\" is transferring %.2f to \"%s\"",user.getPhoneNumber(),amount.doubleValue(),receiverPhoneNumber)
        ));
    }
}
