package daif.tech.repo;

import daif.tech.exception.InvalidCredentialsException;
import daif.tech.exception.UserAlreadyExistsException;
import daif.tech.model.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDB {

    private static volatile Map<String, User> usersMap = new HashMap<>();

    public Optional<User> getUser(String phoneNumber, String password) throws InvalidCredentialsException {

        Optional<User> user = Optional.ofNullable(usersMap.get(phoneNumber));

        if (user.isPresent() && password.equals(user.get().getPassword())) return user;

        throw new InvalidCredentialsException("Invalid credentials");
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if (usersMap.containsKey(user.getPhoneNumber()))
            throw new UserAlreadyExistsException("This user is already exists");

        usersMap.put(user.getPhoneNumber(), user);
    }

    public boolean isUserExists(String phoneNumber){
        return usersMap.containsKey(phoneNumber);
    }

    public void transferToUser(String senderPhoneNumber, String receiverNumber, BigDecimal amount){
        usersMap.get(senderPhoneNumber).withdraw(amount);
        usersMap.get(receiverNumber).deposit(amount);
    }

    public void deposit(String phoneNumber,BigDecimal amount){
        usersMap.get(phoneNumber).deposit(amount);
    }

    public void withdraw(String phoneNumber,BigDecimal amount){
        usersMap.get(phoneNumber).withdraw(amount);
    }


    public double getBalance(String phoneNumber){
        return usersMap.get(phoneNumber).getBalance().doubleValue();
    }
}
