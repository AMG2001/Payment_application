package daif.tech.service;

import daif.tech.exception.InvalidCredentialsException;
import daif.tech.model.User;
import daif.tech.repo.UserDB;

import java.util.Optional;

public class LoginBoardService {

    private UserDB userDB = new UserDB();

    public Optional<User> login(String phoneNumber,String password){
        Optional<User> user = Optional.empty();
        try {
            user = userDB.getUser(phoneNumber,password);
            if(user.isPresent()) System.out.println("Welcome back, "+user.get().getUserName());
        } catch (InvalidCredentialsException e) {
            System.out.println("failed while login : "+e.getMessage());
        }
        return user;
    }
}
