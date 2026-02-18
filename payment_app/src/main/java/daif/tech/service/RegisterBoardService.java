package daif.tech.service;

import daif.tech.exception.UserAlreadyExistsException;
import daif.tech.model.User;
import daif.tech.repo.UserDB;

import java.math.BigDecimal;

public class RegisterBoardService {

    private UserDB userDB = new UserDB();

    public void registerUser(String username,String password,String phoneNumber,BigDecimal initialBalance) {
        User newUser = new User(username, password, phoneNumber, initialBalance);
        try {
            userDB.addUser(newUser);
            System.out.println("User Registered Successfully");
        } catch (UserAlreadyExistsException e) {
            System.out.println("Register failed : User already exists");
        }
    }
}
