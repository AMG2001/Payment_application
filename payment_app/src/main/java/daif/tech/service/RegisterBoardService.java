package daif.tech.service;

import daif.tech.exception.UserAlreadyExistsException;
import daif.tech.model.User;
import daif.tech.repo.UserDB;

import java.math.BigDecimal;

public class RegisterBoardService {

    private UserDB userDB = UserDB.getInstance();

    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.contains(" ") || phoneNumber.length() != 11;
    }

    public boolean validateEnteredUserName(String username) {
        return username.contains(" ");
    }

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
