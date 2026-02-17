package daif.tech.repo;

import daif.tech.exception.InvalidCredentialsException;
import daif.tech.exception.UserAlreadyExistsException;
import daif.tech.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDB {

    private static UserDB userDB;

    private UserDB() {

    }

    public static UserDB getInstance() {
        if (userDB == null) {
            userDB = new UserDB();
        }
        return userDB;
    }

    private Map<String, User> usersMap = new HashMap<>();

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
}
