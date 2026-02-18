package daif.tech.service;

import daif.tech.exception.InvalidCredentialsException;
import daif.tech.model.Transaction;
import daif.tech.model.User;
import daif.tech.repo.TransactionDB;
import daif.tech.repo.UserDB;

import java.util.Optional;

public class LoginBoardService {

    private UserDB userDB = new UserDB();
    private TransactionDB transactionDB = new TransactionDB();

    public Optional<User> login(String phoneNumber,String password){
        Optional<User> user = Optional.empty();
        try {
            user = userDB.getUser(phoneNumber,password);
            if(user.isPresent()) {

                System.out.println("Welcome back, "+user.get().getUserName());

                transactionDB.logNewTransaction(new Transaction(
                        String.format("User with user name : \"%s\" is logging in",user.get().getUserName())
                ));

            }
        } catch (InvalidCredentialsException e) {
            System.out.println("failed while login : "+e.getMessage());
        }
        return user;
    }
}
