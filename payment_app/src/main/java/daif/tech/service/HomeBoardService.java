package daif.tech.service;

import daif.tech.exception.UserNotFoundException;
import daif.tech.model.Transaction;
import daif.tech.model.User;
import daif.tech.repo.TransactionDB;
import daif.tech.repo.UserDB;
import daif.tech.util.UserInfoValidator;

import java.math.BigDecimal;

public class HomeBoardService {

    TransactionDB transactionDB = new TransactionDB();

    private User user;

    public void logout(){
        System.out.printf("User Logged out successfully, goodbye %s",user.getUserName());
        user = null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean checkIfUserExists(String phoneNumber)throws IllegalArgumentException{

        boolean isValidReceiverPhoneNumber = UserInfoValidator.validatePhoneNumber(phoneNumber);

        if(!isValidReceiverPhoneNumber){
            throw new IllegalArgumentException("Invalid Receiver phone number");
        }else if(user.getPhoneNumber().equals(phoneNumber)){
            throw new IllegalArgumentException("User can't transfer for him self");
        }

        return UserDB.getInstance().isUserExists(user.getUserKey());
    }

    public void deposit(BigDecimal amount) throws IllegalArgumentException{
        if(amount.doubleValue() < 0){
            throw new IllegalArgumentException("Amount can't be negative value");
        }
        UserDB.getInstance().deposit(user.getUserKey(),amount);
        System.out.println("Deposited successfully");
        transactionDB.logNewTransaction(new Transaction(
                String.format("User with user name : \"%s\" is depositing %.2f",user.getUserName(),amount.doubleValue())
        ));
    }

    public void withdraw(BigDecimal amount){
        if(amount.doubleValue() <= 0){
            throw new IllegalArgumentException("Entered amount can't be negative or zero");
        }
        UserDB.getInstance().withdraw(user.getUserKey(),amount);
        System.out.printf("Amount withdrawn successfully%n");
        transactionDB.logNewTransaction(new Transaction(
                String.format("User with user name : \"%s\" is withdrawing %.2f",user.getUserName(),amount.doubleValue())
        ));
    }

    public double getBalance(){
        return UserDB.getInstance().getBalance(user.getUserKey());
    }

    public void transfer(String receiverPhoneNumber,BigDecimal amount) throws UserNotFoundException {
        UserDB.getInstance().transferToUser(user.getUserKey(),receiverPhoneNumber,amount);
        System.out.println("Transfer process is done successfully");
        transactionDB.logNewTransaction(new Transaction(
                String.format("User with user name : \"%s\" is transferring %.2f to \"%s\"",user.getUserName(),amount.doubleValue(),receiverPhoneNumber)
        ));
    }

    public void showAccountDetails(){
        System.out.printf("""
                        ############################
                        Account Details :
                        username : %s.
                        age : [%d].
                        phoneNumber : %s.
                        balance : [%.2f].%n
                        #############################""",
                user.getUserName(),
                user.getAge(),
                user.getPhoneNumber(),
                user.getBalance());
    }

    public boolean isCurrentPassword(String enteredPassword){
        return user.getPassword().equals(enteredPassword);
    }
    public void changePassword(String newPassword) throws IllegalArgumentException{
        user.setPassword(newPassword);
    }
}
