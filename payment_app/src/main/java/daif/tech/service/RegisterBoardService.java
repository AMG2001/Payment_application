package daif.tech.service;

import daif.tech.exception.UserAlreadyExistsException;
import daif.tech.model.Transaction;
import daif.tech.model.User;
import daif.tech.repo.TransactionDB;
import daif.tech.repo.UserDB;

import java.math.BigDecimal;

public class RegisterBoardService {

    private UserDB userDB = new UserDB();
    private TransactionDB transactionDB = new TransactionDB();

    public void registerUser(String username,String password,String phoneNumber,BigDecimal initialBalance) {
        User newUser = new User(username, password, phoneNumber, initialBalance);
        try {
            userDB.addUser(newUser);
            transactionDB.logNewTransaction(new Transaction(
                    String.format("User with user name : \"%s\" is Registered",newUser.getUserName())
            ));

            System.out.println("User Registered Successfully");
        } catch (UserAlreadyExistsException e) {
            System.out.println("Register failed : User already exists");
        }
    }
}
